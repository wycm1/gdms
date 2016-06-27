package com.gdms.dao;

import java.util.List;

import com.gdms.pojo.Degree;

public interface DegreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Degree record);

    int insertSelective(Degree record);

    Degree selectByPrimaryKey(Integer id);
    
    List<Degree> selectByStudentId(Integer student_id);

    int updateByPrimaryKeySelective(Degree record);

    int updateByPrimaryKey(Degree record);
}