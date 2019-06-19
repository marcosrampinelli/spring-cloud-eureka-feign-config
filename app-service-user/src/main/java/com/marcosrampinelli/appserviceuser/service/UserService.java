package com.marcosrampinelli.appserviceuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosrampinelli.appserviceuser.clients.BookFeignClient;
import com.marcosrampinelli.appserviceuser.model.Book;

@Service
public class UserService {

	@Autowired
	BookFeignClient bookFeignClient;
	
	public Book retrieveBookInfo(String bookId) {
		
		return bookFeignClient.getBook(bookId);
	}
}
