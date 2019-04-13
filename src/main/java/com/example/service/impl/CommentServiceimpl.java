package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Comment;
import com.example.mapper.CommentCustomMapper;
import com.example.mapper.CommentMapper;
import com.example.pojo.CommentCustom;
import com.example.pojo.Page;
import com.example.utils.PageUtils;
import com.example.utils.ResultData;

@Transactional
@Service
public class CommentServiceimpl {


	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private CommentCustomMapper commentMapperCustom;

	
	public List<Comment> selectCommentsPageByPostId(CommentCustom custom) throws Exception {
		return commentMapperCustom.selectCommentsPageByPostId(custom);
	}


	public ResultData<List<Comment>> selectComments(Integer currentPage, Integer pageCount, 
			Integer postid) throws Exception {
		CommentCustom custom=new CommentCustom();
		custom.setCommentid(postid);
		Page page;
		ResultData<List<Comment>> resultData = new ResultData<>();
		if(currentPage>=2){
			/* @param everyPage 每一页记录数
			 * @param totalCount 总记录数
			 * @param currentPage 当前页数
			 */ 
			page = PageUtils.createPage(pageCount, currentPage);
		}else{
			int count = countCommentBypostid(postid);
			if(count == 0){
//				json.put("pageNum", count);
				resultData.setData(null);
				return resultData;
			}else{
				page = PageUtils.createPage(pageCount, count, currentPage);
//				json.put("pageNum", page.getTotalPage());
			}
		}	
		custom.setPage(page);
		List<Comment> list = commentMapperCustom.selectCommentsPageByPostId(custom);
		resultData.setData(list);
		return resultData;
	}
	
	public int countCommentBypostid(int commentid) {
		return commentMapper.countByExample(commentid);
	}


	public void insert(Comment record) {
		commentMapperCustom.insertCommentGetCommentId(record);
	}


	public Comment selectByPrimaryKey(Integer id) {
		return commentMapper.selectByPrimaryKey(id);
	}
}
