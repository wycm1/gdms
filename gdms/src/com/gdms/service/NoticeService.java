package com.gdms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdms.dao.NoticeMapper;
import com.gdms.dao.UserMapper;
import com.gdms.pojo.Issue;
import com.gdms.pojo.Notice;
import com.gdms.pojo.User;


@Service("noticeService")
public class NoticeService {
	@Resource
	private NoticeMapper noticeDAO;
	@Resource
	private UserMapper userDAO;

	public UserMapper getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserMapper userDAO) {
		this.userDAO = userDAO;
	}

	public NoticeMapper getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeMapper noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	public void addNotice(Notice notice, User user){
		notice.setAuthor(user.getId());
		noticeDAO.insertSelective(notice);
	}
	public List<Notice> getNoticeListByTeacherId(int teacher_id){
		List<Notice> noticeList = noticeDAO.selectByTeacherId(teacher_id);
		return noticeList;
	}
	public Notice getNoticeById(int id){
		return noticeDAO.selectByPrimaryKey(id);
			}
	public void updateContent(Notice notice, User user){
		user.setIssueId(notice.getId());
		userDAO.updateByPrimaryKey(user);
	}
	public boolean create(Notice notice){
		return false;
	}
	public List<Notice> getCollegeNoticeList(){
		return null;
	}
	public List<Notice> getMajorNoticeList(String major){
		return null;
	}
	public List<Notice> getTutorNoticeList(User user){
		return null;
	}

}
