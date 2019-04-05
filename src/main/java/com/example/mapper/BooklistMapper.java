package com.example.mapper;

import java.util.List;

import com.example.entity.Booklist;

public interface BooklistMapper {
	Booklist selectBooklistId(Integer booklist_id);
	
	Booklist selectBooklistName(String booklist_name);
	
	List<Booklist> selectBooklists(int n);//返回n个书单
	
	void interBooklist(Booklist booklist);//新建书单

	void deleteBooklist(Integer booklist_id);//删除书单
}
