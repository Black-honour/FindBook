package com.example.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookMapper {
	
	List<Book> selectBooksN();//搜索n本书
	
	Book selectBookname(String book_name);//搜索单本书
	
	Book selectBookid(Integer bookid);
	
	List<Book> selectBooksA(String auther);//根据作者搜索所有书籍
	
	void insertBook(Book book);//插入书籍
	
	void deleteBook(Integer bookid);//删除书籍
	
	void updateBook(Book book);//更新书籍信息

}
