package com.gdms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.User;
import com.gdms.service.UserService;
@Controller
@RequestMapping("")
public class IndexController{
	private User user;
	@Resource
	private UserService userService;
	@RequestMapping("")
	public String getUser(Model model){
		int i;
		return "redirect:/login";
		
	}
}
