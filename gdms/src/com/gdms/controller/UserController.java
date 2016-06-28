package com.gdms.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.User;
import com.gdms.service.UserService;
import com.gdms.tools.MyHttpMethod;

@Controller
@RequestMapping("")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/validatecode")
	public String getValidateCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> mapString = MyHttpMethod
				.MyGetSession("http://61.139.105.138/");
		String sessionIdString = mapString.get("sessionId");
		// HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("map", mapString);
		byte[] a = MyHttpMethod.MyGetYZM(
				"http://61.139.105.138/CheckCode.aspx", sessionIdString);
		// HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream out;
		try {
			out = response.getOutputStream();
			out.write(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/login")
	public String login(String work_id, String password, Model model,
			HttpSession session, HttpServletRequest request) {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return "login";
		} else {
			if (userService.login(session, work_id, password)) {
				// System.out.println("user：");
				return "succ";
			} else {
				// System.out.println("login false");
				return "login";
			}
		}
	}

	@RequestMapping("/student_register")
	public String studentRegister(User user, String validateCode,
			HttpServletRequest request, Model model) {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return "register";
		} else {
			if (user == null) {
				model.addAttribute("msg", "user为空");
				return "register";
			} else if (user.getIntroduction() == null
					|| user.getMajor() == null || user.getPassword() == null
					|| user.getName() == null || user.getGrade() == null) {
				model.addAttribute("msg", "数据不能为空");
				// System.out.println("数据有问题");
				return "register";
			} else {
				if (userService.register(user, validateCode)) {
					model.addAttribute("user", user);
					// return "register";
					return "redirect:/login";
				} else {
					model.addAttribute("msg", "学号或密码错误");
					return "register";
				}
			}
		}
	}

	@RequestMapping("/teacher_register")
	public String teacherRegister(User user, String validateCode,
			HttpServletRequest request, Model model) {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return "register";
		} else {
			if (user == null) {
				model.addAttribute("msg", "user为空");
				return "register";
			} else if (user.getIntroduction() == null
					|| user.getMajor() == null || user.getPassword() == null
					|| user.getName() == null || user.getAmount() == null
					|| user.getJobtitle() == null) {
				model.addAttribute("msg", "数据不能为空");
				return "register";
			} else {
				if (userService.register(user, validateCode)) {
					model.addAttribute("user", user);
					// return "register";
					return "redirect:/login";
				} else {
					model.addAttribute("msg", "学号或密码错误");
					return "register";
				}
			}
		}
	}

	@RequestMapping("/myinfo")
	public String getMyinfo(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("user", user);
		return null;
	}
}
