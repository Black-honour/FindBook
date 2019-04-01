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
	public ResultData<List<Book>> getBooks(int n){
		ResultData<List<Book>> resultData=new ResultData<List<Book>>();
		
		List<Book> books=bookMapper.selectBooksN(n);
		
		resultData.setCode(1);
		resultData.setMsg("返回n本书成功");
		resultData.setSuccess(true);
		resultData.setData(books);
		return resultData;
	}

}
