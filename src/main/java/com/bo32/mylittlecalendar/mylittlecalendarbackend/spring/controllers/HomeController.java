package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ApiMessage getRoot() {
		return getHome();
	}
	
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public ApiMessage getApi() {
		return getHome();
	}
	
	@RequestMapping(value="/api/home", method=RequestMethod.GET)
	public ApiMessage getHome() {
		return new ApiMessage(ApiMessage.SUCCESS, ApiMessage.HOME);
	}

}
