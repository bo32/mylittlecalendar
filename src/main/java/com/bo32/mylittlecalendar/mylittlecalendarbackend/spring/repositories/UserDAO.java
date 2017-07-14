package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories;

import java.util.List;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.User;

public interface UserDAO {
	
	public List<User> getAllUSers();

	public User getUser(long userId);

	public void deleteUser(User u);

	public void createUser(User user);

	public void updateUser(User user);

}
