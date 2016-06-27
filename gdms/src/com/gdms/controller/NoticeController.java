package com.gdms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.Notice;
import com.gdms.pojo.User;
import com.gdms.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	
	public NoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@RequestMapping("/create")
	public String create(Notice notice,HttpSession session,HttpServletRequest request,Model model){
			String method = request.getMethod();
			if("GET".equals(method)){
				return "addnotice";
				}
			User user = (User)session.getAttribute("user");
			if(user.haveTeacherPermission()){
				noticeService.addNotice(notice,user);
				model.addAttribute("msg", "发布成功");
				return "redirect:/notice/getlistbyteacher?teacher_id="+user.getId();
			}
			else{
					model.addAttribute("msg", "你不是老师，不能发布");
					return "addnotice";
			}
		
	}
	@RequestMapping("/getlist")
	public String getList(int teacher_id, HttpSession session, Model model){
		    User user = (User)session.getAttribute("user");
			List<Notice> teacherNoticeList = noticeService.getNoticeListByTeacherId(teacher_id);
			List<Notice> majorNoticeList = noticeService.getMajorNoticeList(user.getMajor());
			List<Notice> collegeNoticeList = noticeService.getCollegeNoticeList();
			model.addAttribute("teacherNoticeList", teacherNoticeList);
			model.addAttribute("majorNoticeList", majorNoticeList);
			model.addAttribute("collegeNoticeList", collegeNoticeList);
			return "noticeList";
	}
	@RequestMapping("/content")
	public String getContent(int notice_id, HttpSession session,Model model){
		//User user = (User)session.getAttribute("user");
		//System.out.println("service:"+noticeService);
		Notice notice = noticeService.getNoticeById(notice_id);
		//System.out.println("notice"+notice);
		model.addAttribute("notice", notice);
		return "notice_content";
	}
}
