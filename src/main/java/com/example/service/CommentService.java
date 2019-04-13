package com.example.service;

import java.util.List;

import com.example.entity.Comment;
import com.example.utils.ResultData;

public interface CommentService {

    ResultData<List<Comment>> selectComments(Integer page, Integer num,
    		Integer postid) throws Exception;//每一页的记录，评论总数，评论id
	
	void insert(Comment record);  
	 
	Comment selectByPrimaryKey(Integer id);
}
