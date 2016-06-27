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
		 * ������Ϣ
		 */
		messageDAO.insertSelective(msg);
	}
	public List<Message> getMessageListByUser(User user){
		/*
		 * ��ȡ�û�����Ϣ�б�
		 */
		
		return messageDAO.selectByUserId(user.getId());
	}
	public List<Message> getUnreadMessageListByUser(User user){
		/*
		 * ��ȡ�û���δ����Ϣ�б�
		 */
		return messageDAO.selectUnreadByUserId(user.getId());
	}
	public List<Message> getReadMessageListByUser(User user){
		/*
		 * ��ȡ�û����Ѷ���Ϣ�б�
		 */
		return messageDAO.selectReadByUserId(user.getId());
	}
	public Message getMessageContent(int msgId)
	{
		/**
		 * ��ȡ����
		 */
		return messageDAO.selectByPrimaryKey(msgId);
	}
}
