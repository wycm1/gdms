package com.gdms.pojo;

import javax.annotation.Resource;

import com.gdms.service.UserService;

public class StuTutor {
    private Integer id;

    private Integer studentId;

    private Integer teacherId;

    private User student;
    
    private User teacher;
    
    @Resource
    private UserService userService;
    
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    
    public void setInstance()
    {
    	if(studentId!=null&&teacherId!=null){
    		student = userService.getUser(studentId);
    		teacher = userService.getUser(teacherId);
    	}
    }
}