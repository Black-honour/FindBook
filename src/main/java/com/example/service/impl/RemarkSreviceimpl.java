package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Remark;
import com.example.mapper.RemarkCustomMapper;
import com.example.mapper.RemarkMapper;
import com.example.pojo.Page;
import com.example.pojo.RemarkCustom;
import com.example.service.RemarkService;
import com.example.utils.PageUtils;
import com.example.utils.ResultData;

@Service
public class RemarkSreviceimpl implements RemarkService{
	@Autowired
	private RemarkMapper remarkMapper;
	
	@Autowired
	private RemarkCustomMapper remarkCustomMapper;
	
	public int insert(Remark remark) {
		return remarkMapper.insert(remark);
	}
	
	public int update(Remark record) {
		return remarkMapper.updateByExample(record);
	}
	
	public Remark selectByPrimaryKey(Integer id) {
		return remarkMapper.selectByPrimaryKey(id);
	}
	
	public int deleteByPrimaryKey(Integer id) {
		return remarkMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public ResultData<List<Remark>> selectRemarks(Integer currentPage, Integer pageCount,
			Integer forumid) throws Exception {
        RemarkCustom custom=new RemarkCustom();//为post子类
        custom.setForumId(forumid);
		Page page;
		ResultData<List<Remark>> resultData = new ResultData<>();
		
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
		List<Remark> list = remarkCustomMapper.selectRemarkpage(custom);//返回根据创建时间排序的列表
		resultData.setData(list);
		return resultData;
	}

	
	public int countByHomeid(Integer forumid) {
		return remarkMapper.countByExample(forumid);//返回讨论区总行数
	}

}
