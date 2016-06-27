package com.gdms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.Message;
import com.gdms.pojo.User;
import com.gdms.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping("/send")
	public String sendMessage(Message msg, HttpSession session,
			HttpServletRequest request, Model model) {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return "msg";
		} else {
			Date date = new Date();
			if (msg.getNote() == null || msg.getRecvId() == null) {
				model.addAttribute("msg", "数据不能空");
				return "msg";
			} else {
				User user = (User) session.getAttribute("user");
				msg.setFromId(user.getId());
				msg.setStatus(0);
				msg.setDateline(date);
				messageService.sendMessage(msg);
				model.addAttribute("msg", "发送成功");
				return "msg";
			}

		}
	}

	@RequestMapping("/list")
	public String messageList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<Message> messageList = messageService.getMessageListByUser(user);
		model.addAttribute("messageList", messageList);
		return null;
	}

	@RequestMapping("/nureadlist")
	public String messageUnreadList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<Message> messageList = messageService.getUnreadMessageListByUser(user);
		model.addAttribute("messageList", messageList);
		return null;
	}

	@RequestMapping("/content")
	public String messageContent(int msg_id, Model model) {
		Message message = messageService.getMessageContent(msg_id);
		model.addAttribute("message", message);
		return null;
	}
}
