package com.marcosrampinelli.appservicebook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcosrampinelli.appservicebook.model.Book;


@RestController
@RequestMapping("/api")
public class BookController {

	@GetMapping(value="/book/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	Book getBook(@PathVariable("bookId") String bookId) {
		
		return new Book(bookId, "Java", "Publisher name example");
	}
}
