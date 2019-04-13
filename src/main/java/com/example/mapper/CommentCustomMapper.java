package com.example.mapper;

import java.util.List;

import com.example.entity.Comment;
import com.example.pojo.CommentCustom;




public interface CommentCustomMapper {
	
	List<Comment> selectCommentsPageByPostId(CommentCustom custom) throws Exception;
	
	void insertCommentGetCommentId(Comment record);  //返回评论id


}

