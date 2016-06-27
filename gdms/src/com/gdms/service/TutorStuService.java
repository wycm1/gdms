package com.gdms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdms.dao.TutorStuMapper;
import com.gdms.dao.UserMapper;
import com.gdms.pojo.TutorStu;
import com.gdms.pojo.User;

@Service("tutorService")
public class TutorStuService {
	@Resource
	private UserMapper userDAO;
	@Resource
	private TutorStuMapper tutorStuDAO;

	public UserMapper getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserMapper userDAO) {
		this.userDAO = userDAO;
	}

	public TutorStuMapper getTutorStuDAO() {
		return tutorStuDAO;
	}

	public void setTutorStuDAO(TutorStuMapper tutorStuDAO) {
		this.tutorStuDAO = tutorStuDAO;
	}

	public boolean create(int studentId, int teathcerId) {
		User teacher = userDAO.selectByPrimaryKey(teathcerId);
		User student = userDAO.selectByPrimaryKey(studentId);
		if (teacher == null || student == null) {
			return false;
		} else {
			if(teacher.getAmount()==null||tutorStuDAO.selectChoiseCount(teathcerId)>=teacher.getAmount()){
				return false;
			}
			TutorStu tutorStu = new TutorStu();
			tutorStu.setStudentId(studentId);
			tutorStu.setTeathcerId(teathcerId);
			tutorStuDAO.insertSelective(tutorStu);
			return true;
		}
	}
}
