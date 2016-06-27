package com.gdms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdms.dao.StuTutorMapper;
import com.gdms.dao.UserMapper;
import com.gdms.pojo.StuTutor;
import com.gdms.pojo.User;

@Service("stuTutorService")
public class StuTutorService {
	@Resource
	private StuTutorMapper stuTutorDAO;
	@Resource
	private UserMapper userDAO;

	public UserMapper getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserMapper userDAO) {
		this.userDAO = userDAO;
	}

	public StuTutorMapper getStuTutorDAO() {
		return stuTutorDAO;
	}

	public void setStuTutorDAO(StuTutorMapper stuTutorDAO) {
		this.stuTutorDAO = stuTutorDAO;
	}
	
	public boolean create(int teacherId, User student){
		StuTutor stuTutor = new StuTutor();
		User teacher = userDAO.selectByPrimaryKey(teacherId);
		int count = stuTutorDAO.selectChoiseCountByTeacherId(teacher.getId());
		if(teacher.getAmount()!=null&&count<teacher.getAmount()){
			stuTutorDAO.insertSelective(stuTutor);
			return true;
		}
		else{
			return false;
		}
	}
	public int getAmountByTeacherId(int teacher_id){
		return stuTutorDAO.selectChoiseCountByTeacherId(teacher_id);
	}
}
