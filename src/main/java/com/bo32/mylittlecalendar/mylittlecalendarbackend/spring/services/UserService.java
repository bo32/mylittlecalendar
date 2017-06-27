package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.User;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories.UserDAO;

@Service
public class UserService {
	
	@Autowired 
	private UserDAO userDAO;
	
	public List<User> getAllUsers() {
		return userDAO.getAllUSers();
	}

}
