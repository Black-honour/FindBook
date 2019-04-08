package com.example.mapper;

import java.util.List;

import com.example.entity.Post;
import com.example.pojo.PostCustom;



public interface PostMapperCustom {
	
	List<Post> selectPostpage(PostCustom custom) throws Exception;
	//将帖子，或者评论根据创建时间的顺序展示

}
