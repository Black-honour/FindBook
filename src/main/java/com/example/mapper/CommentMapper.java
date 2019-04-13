package com.example.mapper;

import java.util.List;

import com.example.entity.Comment;

public interface CommentMapper {
	int countByExample(Integer commitId);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    List<Comment> selectByExample(Comment example);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Comment record);

}
