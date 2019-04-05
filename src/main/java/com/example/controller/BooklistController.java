package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.entity.Booklist;
import com.example.entity.BooklistMinute;
import com.example.service.BooklistService;
import com.example.utils.ResultData;

@RestController
@RequestMapping("/booklist")
public class BooklistController {

	 @Autowired
	 private BooklistService booklistService;
	 
	 @ResponseBody//搜索书单
	 @RequestMapping(value="/returnbooklist",produces = { "application/json;charset=UTF-8"},
	    method = RequestMethod.POST)
	 ResultData<Booklist> selectBook(
	    		@RequestParam(value = "booklist_name", required = true) String booklist_name
	    		){
	    	ResultData<Booklist> resultData=new ResultData<>();
	    	try {
	    	     resultData=booklistService.selectBooklistN(booklist_name);
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
	 
	 @ResponseBody//添加书单
	 @RequestMapping(value="/addbooklist",produces = { "application/json;charset=UTF-8"},
	    method = RequestMethod.POST)
	 ResultData<Booklist> addBooklist(
	    		@RequestParam(value = "booklist_id", required = true) Integer booklist_id,
	    		@RequestParam(value = "booklist_name", required = true) String booklist_name,
	    		@RequestParam(value = "booklist_intro", required = true) String booklist_intro,
	    		@RequestParam(value = "booklist_cover", required = true) String booklist_cover
	    		){
	    	ResultData<Booklist> resultData=new ResultData<>();
	    	Booklist booklist=new Booklist();
	    	booklist.setBooklist_cover(booklist_cover);
	    	booklist.setBooklist_Id(booklist_id);
	    	booklist.setBooklist_name(booklist_name);
	    	booklist.setBooklist_intro(booklist_intro);
	    	try {
	    	     resultData=booklistService.interBooklist(booklist);
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
	 
	 @ResponseBody//添加书单
	 @RequestMapping(value="/deletebooklist",produces = { "application/json;charset=UTF-8"},
	    method = RequestMethod.POST)
	 ResultData<Booklist> deleteBooklist(
	    		@RequestParam(value = "booklist_id", required = true) Integer booklist_id
	    		){
	    	ResultData<Booklist> resultData=new ResultData<>();
	    	try {
	    	     resultData=booklistService.deleteBooklist(booklist_id);
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
	 
	 @ResponseBody//书单中添加图书
	 @RequestMapping(value="/addbooklistbook",produces = { "application/json;charset=UTF-8"},
	    method = RequestMethod.POST)
	 ResultData<BooklistMinute> addBooklist(
	    		@RequestParam(value = "booklist_id", required = true) Integer booklist_id,
	    		@RequestParam(value = "bookid", required = true) Integer bookid,
	    		@RequestParam(value = "book_name", required = true) String book_name,
	    		@RequestParam(value = "book_intro", required = true) String book_intro,
	    		@RequestParam(value = "book_cover", required = true) String book_cover,
	    		@RequestParam(value = "author", required = true) String author
	    		){
	    	ResultData<BooklistMinute> resultData=new ResultData<>();
	    	BooklistMinute booklistminute=new BooklistMinute();
	    	booklistminute.setBook_cover(book_cover);
	    	booklistminute.setBooklist_id(booklist_id);
	    	booklistminute.setBook_name(book_name);
	    	booklistminute.setBook_intro(book_intro);
	    	booklistminute.setAuthor(author);
	    	try {
	    	     resultData=booklistService.interBooklistMinute(booklistminute);
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
	 
	 @ResponseBody//书单中添加图书
	 @RequestMapping(value="/deletebooklistbook",produces = { "application/json;charset=UTF-8"},
	    method = RequestMethod.POST)
	 ResultData<BooklistMinute> deleteBooklist(
	    		@RequestParam(value = "booklist_id", required = true) Integer booklist_id,
	    		@RequestParam(value = "bookid", required = true) Integer bookid
	    		){
	    	ResultData<BooklistMinute> resultData=new ResultData<>();
	    	
	    	try {
	    	     resultData=booklistService.deleteBooklistMinute(booklist_id,bookid);
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
