package com.gdms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdms.dao.MessageMapper;
import com.gdms.pojo.Message;
import com.gdms.pojo.User;


@Service("messageService")
public class MessageService {
	@Resource
	private MessageMapper messageDAO;

	public MessageMapper getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageMapper messageDAO) {
		this.messageDAO = messageDAO;
	}
	public void sendMessage(Message msg){
		/*
		 * 发送消息
		 */
		messageDAO.insertSelective(msg);
	}
	public List<Message> getMessageListByUser(User user){
		/*
		 * 获取用户的消息列表
		 */
		
		return messageDAO.selectByUserId(user.getId());
	}
	public List<Message> getUnreadMessageListByUser(User user){
		/*
		 * 获取用户的未读消息列表
		 */
		return messageDAO.selectUnreadByUserId(user.getId());
	}
	public List<Message> getReadMessageListByUser(User user){
		/*
		 * 获取用户的已读消息列表
		 */
		return messageDAO.selectReadByUserId(user.getId());
	}
	public Message getMessageContent(int msgId)
	{
		/**
		 * 获取内容
		 */
		return messageDAO.selectByPrimaryKey(msgId);
	}
}
