package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.entity.Remark;

public interface RemarkMapper {
	
	int countByExample(Integer id);//根据讨论区id,返回表的行数

	int deleteByPrimaryKey(Integer id);

    int insert(Remark remark);//插入帖子
    
    //void insert(List<Post> post);//批量插入

    Remark selectByPrimaryKey(Integer id);//

    int updateByExample(@Param("record")Remark record);

}
