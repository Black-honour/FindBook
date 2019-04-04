package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.utils.ResultData;

@Service
public interface BookService {
	
	ResultData<List<Book>> getBooks(int n);//返回n本书
	
	//ResultData<List<Book>> getBooks(String auther);//搜索作者名的书列表
	
	ResultData<Book> addBook(int bookid,String book_cover,int book_grade,int booklist_number,
			int collect,int recommend,String book_name,String auther,String book_intro);
	//增加书籍
	
	ResultData<Book> deleteBook(int bookid);//删除书籍
	
	//更新书籍
	ResultData<Book> updateBook(int bookid,String book_cover,int book_grade,int booklist_number,
			int collect,int recommend,String book_name,String auther,String book_intro);

	ResultData<Book> selectBookname(String book_name);//搜索书名
	
	

	
}
