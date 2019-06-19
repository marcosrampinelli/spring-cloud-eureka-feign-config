package com.marcosrampinelli.appserviceuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcosrampinelli.appserviceuser.model.Book;
import com.marcosrampinelli.appserviceuser.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String index() {
		return "Welcome to user service!";
	}
	
	@GetMapping(value="/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	Book getBook(@PathVariable("bookId") String bookId) {
		return this.userService.retrieveBookInfo(bookId);
	}
	
}
