package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.entity.Post;

public interface PostMapper {

	int countByExample(Integer id);//根据讨论区id,返回表的行数

	int deleteByPrimaryKey(Integer id);

    int insert(Post post);//插入帖子
    
    //void insert(List<Post> post);//批量插入

    Post selectByPrimaryKey(Integer id);//

    int updateByExample(@Param("record")Post record);
}
