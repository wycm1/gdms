package com.gdms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("degree")
public class DegreeController {
	@RequestMapping("/getmydegreelist")
	public String getMyDegreeList(){
		/**
		 * 获取自己的进度列表
		 */
		return null;
	}
	@RequestMapping("/getmystudentlist")
	public String getStudentDegreeList(){
		/**
		 * 获取老师自己的学生进度列表
		 */
		return null;
	}
	@RequestMapping("/getlistbystudent")
	public String getDegreeListByStudent(int student_id){
		/**
		 * 获取某个学生的进度列表
		 */
		return null;
	}
	@RequestMapping("/upload_degree")
	public String createDegree(){
		/**
		 * 创建进度
		 */
		return null;
	}
	@RequestMapping("/comment")
	public String commentDegree(){
		/**
		 * 老师评论进度
		 */
		return null;
	}
}
