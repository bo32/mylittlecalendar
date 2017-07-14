package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> getAllUSers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
