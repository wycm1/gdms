package com.gdms.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.gdms.dao.UserMapper;
import com.gdms.pojo.User;
import com.gdms.tools.ValidateUser;

@Service("userService")
public class UserService {
	@Resource
	private UserMapper userDAO;

	public User getUser(int id) {
		return userDAO.selectByPrimaryKey(id);
	}

	// µÇÂ½
	public boolean login(HttpSession session, String  workId, String password) {
		// TODO Auto-generated method stub
		//String passwdMd5 = Md5Util.Convert2Md5(password);
		User user = userDAO.selectByWorkIdandPassword(workId, password);
		if (user != null) {
			session.setAttribute("user", user);
			return true;
		}
		return false; 
	}

	// ×¢Ïú
	public void logout(HttpSession session) {
		session.removeAttribute("user");
	}
	// ×¢²á
	public boolean register(User user, String validateCode){
		User user_tmp = userDAO.selectByWorkId(user.getWorkId());
		if(user_tmp!=null){
		    return false;
		}
		else{
			if(ValidateUser.Validate(user, validateCode)){
			    userDAO.insertSelective(user);
			    return true;
			}
			else{
				return false;
			}
		}
	}
	public List<User> getTeacherByMajor(String major){
		List<User> teacherList = userDAO.selectTeacherByMajor(major);
		return teacherList;
	}
	public List<User> getStudentByTeacher(User teacher){
		return userDAO.selectChoiseMeStudent(teacher.getId());
	}
}
