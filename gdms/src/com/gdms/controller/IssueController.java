package com.gdms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.Issue;
import com.gdms.pojo.User;
import com.gdms.service.IssueService;
import com.gdms.service.UserService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	@Resource
	private IssueService issueService;
	@Resource
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public IssueService getIssueService() {
		return issueService;
	}
	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}
	@RequestMapping("/create")
	public String create(HttpSession session, Issue issue){
		User user = (User) session.getAttribute("user");
		if(user.haveTeacherPermission()){
			issue.setUserId(user.getId());
			issueService.createIssue(issue);
		}
		else if(user.isStudent()){
			
		}
		return null;
	}
//	@RequestMapping("/studentCreate")
//	public String studentCreate(Issue issue){
//		issueService.createIssue(issue);
//		return null;
//	}
	@RequestMapping("/getlistbyteacher")
	public String getListByTeacher(int teacher_id, Model model){
		List<Issue> issueList = issueService.getIssueListByTeacher(teacher_id);
		model.addAttribute("issueList", issueList);
		return null;
	}
	@RequestMapping("/choise")
	public String choiseIssue(HttpSession session, int issue_id){
		User user = (User) session.getAttribute("user");
		if(user.isStudent()){
			user.setIssueId(issue_id);
			userService.updateUserById(user);
		}
		return null;
	}
}
