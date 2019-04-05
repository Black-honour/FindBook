package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.entity.Booklist;
import com.example.entity.BooklistMinute;
import com.example.utils.ResultData;

public interface BooklistService {
	ResultData<List<Booklist>> ReturnBooklists();//返回书单列表
	
	ResultData<Booklist> selectBooklistI(Integer booklist_id);
	
	ResultData<Booklist> selectBooklistN(String booklist_name);
	
	ResultData<Booklist> interBooklist(Booklist booklist);//新建书单
	ResultData<BooklistMinute> interBooklistMinute(BooklistMinute booklistminute);//添加书单中的书
	ResultData<BooklistMinute> deleteBooklistMinute(Integer booklist_id,Integer bookid);//删除书单中的书

	ResultData<Booklist> deleteBooklist(Integer booklist_id);//删除书单
}
