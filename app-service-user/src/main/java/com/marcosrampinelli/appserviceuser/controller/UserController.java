package com.marcosrampinelli.appserviceuser.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String index() {
		return "Welcome!";
	}
	
	
}
