package com.gdms.dao;

import java.util.List;

import com.gdms.pojo.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);
    
    List<Notice> selectCollage();
    
    List<Notice> selectByTeacherId(Integer teacherId);
    
    List<Notice> selectByMajor(String major);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);
}