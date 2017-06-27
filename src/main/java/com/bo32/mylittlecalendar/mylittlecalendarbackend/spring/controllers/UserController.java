package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.User;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/users", method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/api/createUser", method=RequestMethod.POST)
	public ApiMessage getcreateUser(Principal principal, @RequestParam("name") String name) {
		return new ApiMessage(ApiMessage.SUCCESS, "User successfully created.");
	}
	
}
