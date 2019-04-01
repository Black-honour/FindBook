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
    @RequestMapping(value="/register",produces = { "application/json;charset=UTF-8" },
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
    	
}
    
    
    