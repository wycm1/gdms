package com.gdms.dao;

import java.util.List;

import com.gdms.pojo.Issue;

public interface IssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Integer id);
    
    List<Issue> selectListByTeacherId(Integer teacherId);
    
    Issue selectByStudentId(Integer studentId);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
}