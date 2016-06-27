package com.gdms.dao;

import java.util.List;

import com.gdms.pojo.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);
    
    List<Message> selectByUserId(Integer userId);
    
    List<Message> selectUnreadByUserId(Integer userId);
    
    List<Message> selectReadByUserId(Integer userId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
}