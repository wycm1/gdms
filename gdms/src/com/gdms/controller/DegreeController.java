package com.gdms.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gdms.pojo.Comment;
import com.gdms.pojo.Degree;
import com.gdms.pojo.User;
import com.gdms.service.DegreeService;
import com.gdms.service.TutorStuService;
import com.gdms.service.UserService;

@Controller
@RequestMapping("degree")
public class DegreeController {
	@Resource
	private DegreeService degreeService;
	@Resource
	private UserService userService;
	@Resource
	private TutorStuService tutorStuService;
	public TutorStuService getTutorStuService() {
		return tutorStuService;
	}

	public void setTutorStuService(TutorStuService tutorStuService) {
		this.tutorStuService = tutorStuService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DegreeService getDegreeService() {
		return degreeService;
	}

	public void setDegreeService(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	@RequestMapping("/getmydegreelist")
	public String getMyDegreeList(HttpSession session, Model model) {
		/**
		 * 获取自己的进度列表
		 */
		User user = (User) session.getAttribute("user");
		if (user.isStudent()) {
			getDegreeListByStudentId(user.getId(), model);
		} else {
			model.addAttribute("msg", "没有权限");
		}
		return null;
	}

	public void getDegreeListByStudentId(int studentId, Model model) {
		List<Degree> degreeList = degreeService
				.getDegreeListByStudentId(studentId);
		model.addAttribute("degreeList", degreeList);
	}

	@RequestMapping("/getDegreelist")
	public String getStudentDegreeList(int studentId, Model model) {
		/**
		 * 获取学生进度列表
		 */
		getDegreeListByStudentId(studentId, model);
		return null;
	}

	// @RequestMapping("/getmystudentlist")
	// public String getStudentDegreeList(){
	// /**
	// * 获取老师自己的学生列表
	// */
	// return null;
	// }
	// @RequestMapping("/getlistbystudent")
	// public String getDegreeListByStudent(int student_id){
	// /**
	// * 获取某个学生的进度列表
	// */
	// return null;
	// }
	@RequestMapping("/upload_degree")
	public String createDegree(@RequestParam(value = "file", required = false) MultipartFile file, Degree degree, HttpServletRequest request, Model model) {
		/**
		 * 创建进度
		 */
		String path = request.getSession().getServletContext().getRealPath("") + "/upload/";//
		String fileName = file.getOriginalFilename();
		fileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        String filePathName = path + fileName;
        System.out.println("文件上传至\n" + filePathName + "\n成功！");
        degree.setPath(filePathName);
        degreeService.create(degree);
        model.addAttribute("msg", "上传成功");
		return null;
	}

	@RequestMapping("/comment")
	public String commentDegree(Comment comment, HttpSession session,
			Model model) {
		/**
		 * 老师评论进度
		 */
		User user = (User) session.getAttribute("user");
		degreeService.commentDegree(comment, user);
		model.addAttribute("msg", "评论成功");
		return null;
	}
	@RequestMapping("/getStudentList")
	public String getStudentListByUser(HttpSession session, Model model){
		/**
		 * 获取老师自己的学生列表
		 */
		User teacher = (User) session.getAttribute("user");
		List<User> studentList = userService.getStudentByTeacher(teacher);
		model.addAttribute("studentList", studentList);
		return null;
	}
	@RequestMapping("/getMyTutor")
	public String getMyTutor(HttpSession session, Model model){
		/**
		 * 获取学生的导师
		 */
		User student = (User) session.getAttribute("user");
		User teacher = tutorStuService.getTeacherByStudent(student.getId());
		model.addAttribute("teacher", teacher);
		return null;
	}
}
