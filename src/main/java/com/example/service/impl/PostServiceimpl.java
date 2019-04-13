package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Post;
import com.example.mapper.PostCustomMapper;
import com.example.mapper.PostMapper;
import com.example.pojo.Page;
import com.example.pojo.PostCustom;
import com.example.service.PostService;
import com.example.utils.PageUtils;
import com.example.utils.ResultData;


@Service
public class PostServiceimpl implements PostService{
	@Autowired
	private PostMapper postMapper;
	
	@Autowired
	private PostCustomMapper postMapperCustom;
	
	public int insert(Post post) {
		return postMapper.insert(post);
	}
	
	public int update(Post record) {
		return postMapper.updateByExample(record);
	}
	
	public Post selectByPrimaryKey(Integer id) {
		return postMapper.selectByPrimaryKey(id);
	}
	
	public int deleteByPrimaryKey(Integer id) {
		return postMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public ResultData<List<Post>> selectPosts(Integer currentPage, Integer pageCount,
			Integer forumid) throws Exception {
        PostCustom custom=new PostCustom();//为post子类
        custom.setForumId(forumid);
		Page page;
		ResultData<List<Post>> resultData = new ResultData<>();
		
		if(currentPage>=2){
			page = PageUtils.createPage(pageCount, currentPage);//构造分页
		}else{
			int count = countByHomeid(forumid);//论坛帖子数
			page = PageUtils.createPage(pageCount, count, currentPage);
			if(count == 0){
//				json.put("pageNum", count);
				resultData.setData(null);
			}else{
//				json.put("pageNum", page.getTotalPage());
				page = PageUtils.createPage(pageCount, currentPage);
			}
		}	
		custom.setPage(page);
		List<Post> list = postMapperCustom.selectPostpage(custom);//返回根据创建时间排序的列表
		resultData.setData(list);
		return resultData;
	}

	
	public int countByHomeid(Integer homeid) {
		return postMapper.countByExample(homeid);//返回讨论区总行数
	}
	

}
