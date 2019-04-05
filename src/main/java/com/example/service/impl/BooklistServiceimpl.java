package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booklist;
import com.example.entity.BooklistMinute;
import com.example.mapper.BookMapper;
import com.example.mapper.BooklistMapper;
import com.example.mapper.BooklistMinuteMapper;
import com.example.service.BookService;
import com.example.service.BooklistService;
import com.example.utils.ResultData;

@Service
public class BooklistServiceimpl implements BooklistService{

	@Autowired
	private BooklistMapper booklistMapper;
	
	@Autowired
	private BooklistMinuteMapper booklistminuteMapper;

	@Override
	public ResultData<List<Booklist>> ReturnBooklists(){
		ResultData<List<Booklist>> resultData=new ResultData<>();
		return resultData;
	}
	
	@Override//根据id搜索书单
	public ResultData<Booklist> selectBooklistI(Integer booklist_id){
		ResultData<Booklist> resultData=new ResultData<>();
		Booklist booklist=new Booklist();
		booklist=booklistMapper.selectBooklistId(booklist_id);
		
		resultData.setCode(1);
		resultData.setMsg("返回书单成功");
		resultData.setSuccess(true);
		resultData.setData(booklist);
		return resultData;
	}
	
	@Override//根据书单名搜索书单
	public ResultData<Booklist> selectBooklistN(String booklist_name){
		ResultData<Booklist> resultData=new ResultData<>();
		Booklist booklist=new Booklist();
		booklist=booklistMapper.selectBooklistName(booklist_name);
		
		resultData.setCode(1);
		resultData.setMsg("返回书单成功");
		resultData.setSuccess(true);
		resultData.setData(booklist);
		return resultData;
	}
	
	@Override//新建书单
	public ResultData<Booklist> interBooklist(Booklist booklist) {
		ResultData<Booklist> resultData=new ResultData<>();
		
		booklistMapper.interBooklist(booklist);
		resultData.setCode(1);
		resultData.setMsg("新建书单成功");
		resultData.setSuccess(true);
		resultData.setData(booklist);
		return resultData;
	}
	
	@Override//删除书单
	public ResultData<Booklist> deleteBooklist(Integer booklist_id){
		ResultData<Booklist> resultData=new ResultData<>();
		Booklist booklist =new Booklist();
		booklist=booklistMapper.selectBooklistId(booklist_id);
		
		booklistMapper.deleteBooklist(booklist_id);
		
		resultData.setCode(1);
		resultData.setMsg("删除书单成功");
		resultData.setSuccess(true);
		resultData.setData(booklist);
		return resultData;
		
	}
	
	@Override//书单中添加图书
	public ResultData<BooklistMinute> interBooklistMinute(BooklistMinute booklistminute){
		ResultData<BooklistMinute> resultData=new ResultData<>();
		
		booklistminuteMapper.addBooklistBook(booklistminute);
		resultData.setCode(1);
		resultData.setMsg("添加成功");
		resultData.setSuccess(true);
		resultData.setData(booklistminute);
		return resultData;
	}
	
	@Override//书单中删除图书
	public ResultData<BooklistMinute> deleteBooklistMinute(Integer booklist_id,Integer bookid){
		ResultData<BooklistMinute> resultData=new ResultData<>();
		booklistminuteMapper.deleteBooklistBook(booklist_id, bookid);
		resultData.setCode(1);
		resultData.setMsg("删除成功");
		resultData.setSuccess(true);
		return resultData;
	}
	
}
