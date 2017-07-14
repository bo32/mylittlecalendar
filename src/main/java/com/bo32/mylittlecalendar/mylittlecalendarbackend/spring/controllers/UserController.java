package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.beans.ApiMessage;
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
	
	@RequestMapping(value="/api/users/create", method=RequestMethod.POST)
	public ApiMessage getCreateUser(Principal principal, @RequestBody final User user) {
		userService.createUser(user);
		return new ApiMessage(ApiMessage.SUCCESS, String.format("User %d successfully created.", user.getId()));
	}
	
	@RequestMapping(value="/api/users/update", method=RequestMethod.POST)
	public ApiMessage getUpdateUser(Principal principal, @RequestBody final User user) {
		userService.updateUser(user);
		return new ApiMessage(ApiMessage.SUCCESS, String.format("User %d successfully updated.", user.getId()));
	}
	
	@RequestMapping(value="/api/users/delete", method=RequestMethod.POST)
	public ApiMessage getDeleteUser(Principal principal, @RequestParam("userId") long userId) {
		User u = userService.getUser(userId);
		if (u != null) {
			userService.deleteUser(u);
		} else {
			return new ApiMessage(ApiMessage.FAILURE, String.format("User %d couldn't be found.", userId));
		}
		return new ApiMessage(ApiMessage.SUCCESS, String.format("User %s successfully deleted.", u.getName()));
	}
	
}
