package com.example.service;
import java.util.List;

import com.example.entity.Remark;
import com.example.utils.ResultData;

public interface RemarkService {

	int insert(Remark record);//插入帖子
	 
	 int update(Remark record);//更新帖子

	 ResultData<List<Remark>> selectRemarks(Integer page, Integer num, Integer forumid) 
			 throws Exception;//返回论坛帖子列表帖子

	 Remark selectByPrimaryKey(Integer id);//根据id查找帖子
	 int deleteByPrimaryKey(Integer id);
}
