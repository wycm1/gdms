package com.gdms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.User;

@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("/test")
	public String register(User user, HttpServletRequest request, Model model){
		System.out.print(user.getName());
		model.addAttribute("user", user);
		return "test";
	}
}
