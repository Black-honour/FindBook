package com.example.mapper;

import com.example.entity.BooklistMinute;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BooklistMinuteMapper {

	List<BooklistMinute> selectBooklist(Integer booklist_id);//查询书单详情
	
	void deleteBooklistBook(@Param("booklist_id")Integer booklist_id,@Param("bookid")Integer bookid);
	
	void addBooklistBook(BooklistMinute booklistMinute);
	
	
	
}
