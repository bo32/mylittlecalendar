package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.beans.ApiMessage;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.TestUtils;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.User;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	private List<User> users;
	private User user;
	
	@Before
	public void setUp() {
		users = new ArrayList<User>();
		long[] ids = {10L, 20L, 30L};
		String[] names = {"Darth Vader", "Jane Doe", "John Doe"};
		for (int i = 0; i < ids.length; i++) {
			User user = new User();
			user.setId(ids[i]);
			user.setName(names[i]);
			users.add(user);
		}
		
		user = users.get(0);
	}
	@Test
	public void testAllUsers() throws Exception {
		
		
		when(userService.getAllUsers()).thenReturn(users);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.[0].id", is(10)))
				.andExpect(jsonPath("$.[1].name", is("Jane Doe")));
	}
	
	@Test
	public void testAddUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
					.contentType(TestUtils.APPLICATION_JSON_UTF8)
					.content(TestUtils.convertObjectToJsonBytes(user)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)));
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/users/update")
					.contentType(TestUtils.APPLICATION_JSON_UTF8)
					.content(TestUtils.convertObjectToJsonBytes(user)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)));
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		User u = new User();
		u.setId(11L);
		u.setName("John");
		
		when(userService.getUser(11L)).thenReturn(u);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/users/delete")
					.param("userId", "10"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.status", is(ApiMessage.FAILURE)));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/users/delete")
				.param("userId", "11"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)));
	}

}
