package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import com.example.utils.ResultData;

@RestController
@RequestMapping("/book")
public class BookController {
 
    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;
    
    //搜索单本书籍
    @ResponseBody
    @RequestMapping(value="/returnbook",produces = { "application/json;charset=UTF-8"},
    method = RequestMethod.POST)
    ResultData<Book> selectBook(
    		@RequestParam(value = "book_name", required = true) String book_name
    		){
    	ResultData<Book> resultData=new ResultData<>();
    	try {
    	     resultData=bookService.selectBookname(book_name);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
    	return resultData;
    }
    
    //返回书籍
    @ResponseBody
    @RequestMapping(value="/returnbooks",produces = { "application/json;charset=UTF-8"},
    method = RequestMethod.POST)
    ResultData<List<Book>> selectBooks(
    		//@RequestParam(value = "number", required = true) int number
    		){
    	int number=5;
    	ResultData<List<Book>> resultData=new ResultData<>();
    	try {
			resultData = bookService.getBooks(number);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
    	return resultData;
    }
    
    //根据作者搜书
    @ResponseBody
    @RequestMapping(value="/returnauthorbooks",produces = { "application/json;charset=UTF-8"},
    method = RequestMethod.POST)
    ResultData<List<Book>> selectBooksA(
    		@RequestParam(value = "author", required = true) String author
    		){
    	ResultData<List<Book>> resultData=new ResultData<>();
    	try {
			resultData = bookService.getBooks(author);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
    	return resultData;
    }
    
    //增加书籍
    @ResponseBody
    @RequestMapping(value="/addbook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> addBook(
    		@RequestParam(value = "book_cover", required = true) String book_cover,
    		@RequestParam(value = "book_grade", required = true) Integer book_grade,
    		@RequestParam(value = "booklist_number", required = true) Integer booklist_number,
    		@RequestParam(value = "collect", required = true) Integer collect,
    		@RequestParam(value = "recommend", required = true) Integer recommend,
    		@RequestParam(value = "book_name", required = true) String book_name,
    		@RequestParam(value = "author", required = true) String author,
    		@RequestParam(value = "book_intro", required = true) String book_intro
    		){
    	ResultData<Book> resultData=new ResultData<>();
    	Book book =new Book();
    	book.setBook_cover(book_cover);
    	book.setBook_grade(book_grade);
    	book.setBooklist_number(booklist_number);
    	book.setCollect(collect);
    	book.setRecommend(recommend);
    	book.setBook_name(book_name);
    	book.setAuthor(author);
    	book.setBook_intro(book_intro);
    	try {
    		int newbookid=bookService.addBook(book);
    		Book newbook=bookMapper.selectBookid(newbookid);
    		resultData.setCode(1);
    		resultData.setData(newbook);
    		resultData.setMsg("添加书籍成功");
    		resultData.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(false);
			return resultData;
		}
    	return resultData;    	
    }
    
    //删除书籍
    @ResponseBody
    @RequestMapping(value="/deletebook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> deleteBook(
    		@RequestParam(value = "bookid", required = true) Integer bookid
    		){
    	ResultData<Book> resultData=new ResultData<>();
    	try {
			resultData = bookService.deleteBook(bookid);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
    	return resultData; 
    }
    
    //更新书籍
    @ResponseBody
    @RequestMapping(value="/updatebook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> updateBook(
    		@RequestParam(value = "bookid", required = true) Integer bookid,
    		@RequestParam(value = "book_cover", required = true) String book_cover,
    		@RequestParam(value = "book_grade", required = true) Integer book_grade,
    		@RequestParam(value = "booklist_number", required = true) Integer booklist_number,
    		@RequestParam(value = "collect", required = true) Integer collect,
    		@RequestParam(value = "recommend", required = true) Integer recommend,
    		@RequestParam(value = "book_name", required = true) String book_name,
    		@RequestParam(value = "author", required = true) String author,
    		@RequestParam(value = "book_intro", required = true) String book_intro){
    	ResultData<Book> resultData=new ResultData<>();
    	try {
			resultData = bookService.updateBook(bookid,book_cover,book_grade,booklist_number,
			         collect,recommend,book_name,author,book_intro);
		} catch (Exception e) {
			e.printStackTrace();
			//LogUtils.error(e.toString());
			resultData.setCode(-200);
			resultData.setMsg("处理异常");
			resultData.setSuccess(true);
			return resultData;
		}
    	return resultData;    	
    }
    
}
    
    
    