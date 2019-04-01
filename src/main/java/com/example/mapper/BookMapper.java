package com.example.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookMapper {
	
	List<Book> selectBooksN(int n);//搜索n本书
	
	Book selectBook(String book_name);//搜索单本书
	
	List<Book> selectBooks(String auther);//根据作者搜索所有书籍
	
	void insertBook(Book book);//插入书籍
	
	void deleteBook(Book book);//删除书籍

}
