package com.gdms.dao;

import java.util.List;

import com.gdms.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByWorkId(String work_id);
    
    List<User> selectTeacherByMajor(String major);
    
    List<User> selectChoiseMeStudent(Integer teacher_id);
    
    User selectByWorkIdandPassword(String work_id, String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getLastStudentByMajor(String major);
}