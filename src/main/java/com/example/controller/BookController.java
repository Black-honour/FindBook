package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.service.BookService;
import com.example.utils.ResultData;

@RestController
@RequestMapping("/book")
public class BookController {
 
    @Autowired
    private BookService bookService;
    
    //返回书籍
    @ResponseBody
    @RequestMapping(value="/returnbooks",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.GET)
    ResultData<List<Book>> selectBooks(
    		@RequestParam(value = "number", required = true) int number
    		){
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
    
    //增加书籍
    @ResponseBody
    @RequestMapping(value="/addbook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> addBook(
    		@RequestParam(value = "bookid", required = true) int bookid,
    		@RequestParam(value = "book_cover", required = true) String book_cover,
    		@RequestParam(value = "book_grade", required = true) int book_grade,
    		@RequestParam(value = "booklist_number", required = true) int booklist_number,
    		@RequestParam(value = "collect", required = true) int collect,
    		@RequestParam(value = "recommend", required = true) int recommend,
    		@RequestParam(value = "book_name", required = true) String book_name,
    		@RequestParam(value = "auther", required = true) String auther,
    		@RequestParam(value = "book_intro", required = true) String book_intro){
    	ResultData<Book> resultData=new ResultData<>();
    	try {
			resultData = bookService.addBook(bookid,book_cover,book_grade,booklist_number,
			         collect,recommend,book_name,auther,book_intro);
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
    
    //删除书籍
    @ResponseBody
    @RequestMapping(value="/deletebook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> deleteBook(
    		@RequestParam(value = "bookid", required = true) int bookid
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
    
    @ResponseBody
    @RequestMapping(value="/updatebook",produces = { "application/json;charset=UTF-8" },
    method = RequestMethod.POST)
    ResultData<Book> updateBook(
    		@RequestParam(value = "bookid", required = true) int bookid,
    		@RequestParam(value = "book_cover", required = true) String book_cover,
    		@RequestParam(value = "book_grade", required = true) int book_grade,
    		@RequestParam(value = "booklist_number", required = true) int booklist_number,
    		@RequestParam(value = "collect", required = true) int collect,
    		@RequestParam(value = "recommend", required = true) int recommend,
    		@RequestParam(value = "book_name", required = true) String book_name,
    		@RequestParam(value = "auther", required = true) String auther,
    		@RequestParam(value = "book_intro", required = true) String book_intro){
    	ResultData<Book> resultData=new ResultData<>();
    	try {
			resultData = bookService.updateBook(bookid,book_cover,book_grade,booklist_number,
			         collect,recommend,book_name,auther,book_intro);
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
    
    
    