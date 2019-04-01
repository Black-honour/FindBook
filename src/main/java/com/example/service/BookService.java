package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.utils.ResultData;

@Service
public interface BookService {
	
	ResultData<List<Book>> getBooks(int n);//返回n本书
	
	

	
}
