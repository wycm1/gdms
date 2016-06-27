package com.gdms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.Issue;

@Controller
@RequestMapping("/issue")
public class IssueController {
	@RequestMapping("/create")
	public String create(Issue issue){
		return null;
	}
	@RequestMapping("/getlistbyteacher")
	public String getListByTeacher(int teacher_id){
		return null;
	}
	@RequestMapping("/choise")
	public String choiseIssue(int issue_id){
		return null;
	}
}
