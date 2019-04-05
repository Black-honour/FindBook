package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import com.example.utils.ResultData;

@Service
public class BookServiceimpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public ResultData<List<Book>> getBooks(int n){//返回n本书
		ResultData<List<Book>> resultData=new ResultData<List<Book>>();
		
		List<Book> books=bookMapper.selectBooksN();
		
		resultData.setCode(1);
		resultData.setMsg("返回5本书成功");
		resultData.setSuccess(true);
		resultData.setData(books);
		return resultData;
	}
	
	//根据书名搜书
	@Override
	public ResultData<Book> selectBookname(String book_name){
		ResultData<Book> resultData=new ResultData<>();
		Book book=new Book();
		book=getBook(book_name);
		
		resultData.setCode(1);
		resultData.setData(book);
		resultData.setMsg("返回书籍成功");
		resultData.setSuccess(true);
		return resultData;	
	}
	
	
	@Override
	public ResultData<Book> addBook(Integer bookid,String book_cover,Integer book_grade,
			Integer booklist_number,
			Integer collect,Integer recommend,String book_name,String author,
			String book_intro){
		ResultData<Book> resultData=new ResultData<>();
		Book book=new Book();
		
		book.setBookid(bookid);
		book.setBook_cover(book_cover);
		book.setBook_grade(book_grade);
		book.setBooklist_number(booklist_number);
		book.setCollect(collect);
		book.setRecommend(recommend);
		book.setBook_name(book_name);
		book.setAuther(author);
		book.setBook_intro(book_intro);
		bookMapper.insertBook(book);
		
		resultData.setCode(1);
		resultData.setData(book);
		resultData.setMsg("添加书籍成功");
		resultData.setSuccess(true);
		return resultData;
	}

	@Override//删除书籍
	public ResultData<Book> deleteBook(int bookid){
		ResultData<Book> resultData=new ResultData<Book>();
		Book book=new Book();
		book=getBook(bookid);
		
		bookMapper.deleteBook(bookid);
		
		resultData.setCode(1);
		resultData.setSuccess(true);
		resultData.setMsg("删除书籍成功");
		resultData.setData(book);
		return resultData;		
	}
	
	//更新书籍所有信息
	@Override
	public ResultData<Book> updateBook(int bookid,String book_cover,int book_grade,int booklist_number,
			int collect,int recommend,String book_name,String author,String book_intro
			){
		ResultData<Book> resultData=new ResultData<Book>();
		
		Book book =new Book();
		
		book=getBook(bookid);
		
		book.setBook_cover(book_cover);
		book.setBook_grade(book_grade);
		book.setBooklist_number(booklist_number);
		book.setCollect(collect);
		book.setRecommend(recommend);
		book.setBook_name(book_name);
		book.setAuther(author);
		book.setBook_intro(book_intro);
		
		bookMapper.updateBook(book);
		
		resultData.setCode(1);
		resultData.setSuccess(true);
		resultData.setMsg("更新书籍成功");
		resultData.setData(book);
		return resultData;	
		
	}
	
	private Book getBook(int bookid) {
		Book book=new Book();
		book=bookMapper.selectBookid(bookid);
		return book;
	}
	
	private Book getBook(String book_name) {
		Book book=new Book();
		book=bookMapper.selectBookname(book_name);
		return book;
	}
	
}
