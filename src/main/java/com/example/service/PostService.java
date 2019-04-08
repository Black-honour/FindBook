package com.example.service;

import java.util.List;

import com.example.entity.Post;
import com.example.utils.ResultData;

public interface PostService {
	
	 int insert(Post record);//插入帖子
	 
	 int update(Post record);//更新帖子

	 ResultData<List<Post>> selectPosts(Integer page, Integer num, Integer forumid) 
			 throws Exception;//返回论坛帖子列表帖子

	 Post selectByPrimaryKey(Integer id);//根据id查找帖子
}
