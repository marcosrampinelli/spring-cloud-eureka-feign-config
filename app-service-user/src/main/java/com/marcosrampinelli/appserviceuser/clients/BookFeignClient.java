package com.marcosrampinelli.appserviceuser.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcosrampinelli.appserviceuser.model.Book;


@FeignClient("appservicebook")
public interface BookFeignClient {

	@RequestMapping(method= RequestMethod.GET, value="/api/book/{bookId}", consumes = "application/json")
    Book getBook(@PathVariable("bookId") String bookId);
}
