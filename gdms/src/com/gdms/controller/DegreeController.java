package com.gdms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("degree")
public class DegreeController {
	@RequestMapping("/getmydegreelist")
	public String getMyDegreeList(){
		/**
		 * ��ȡ�Լ��Ľ����б�
		 */
		return null;
	}
	@RequestMapping("/getmystudentlist")
	public String getStudentDegreeList(){
		/**
		 * ��ȡ��ʦ�Լ���ѧ�������б�
		 */
		return null;
	}
	@RequestMapping("/getlistbystudent")
	public String getDegreeListByStudent(int student_id){
		/**
		 * ��ȡĳ��ѧ���Ľ����б�
		 */
		return null;
	}
	@RequestMapping("/upload_degree")
	public String createDegree(){
		/**
		 * ��������
		 */
		return null;
	}
	@RequestMapping("/comment")
	public String commentDegree(){
		/**
		 * ��ʦ���۽���
		 */
		return null;
	}
}
