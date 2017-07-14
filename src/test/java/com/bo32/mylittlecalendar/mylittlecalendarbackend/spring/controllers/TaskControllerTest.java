package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Task;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.CalendarService;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskService taskService;
	@MockBean
	private CalendarService calendarService;
	
	private Task task1, task2, task3;
	private List<Task> allTasks;
	
	@Before
	public void setUp() {
		task1 = new Task();
		task1.setId(1L);
		task1.setLabel("Doctor");

		task2 = new Task();
		task2.setId(2L);
		task2.setLabel("Beer");

		task3 = new Task();
		task3.setId(3L);
		task3.setLabel("Cinema");
		
		allTasks = new ArrayList<Task>();
		allTasks.add(task1);
		allTasks.add(task2);
		allTasks.add(task3);
	}
	
	@Test
	public void testCreateTask() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date from = sdf.parse("01/01/2017");
		Date to = sdf.parse("02/01/2017");
		Task task = new Task();
		task.setId(1L);
		task.setLabel("Test Task");
		task.setFrom(from);
		task.setTo(to);
		task.setDescription("Test description.");
		
		mockMvc.perform(MockMvcRequestBuilders.post(
					"/api/calendars/{calendarId}/tasks/create", 11)
				.contentType(TestUtils.APPLICATION_JSON_UTF8)
				.content(TestUtils.convertObjectToJsonBytes(task)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)))
			;
	}
	
	@Test
	public void testGetTask() throws Exception {
		when(taskService.getTask(anyLong())).thenReturn(task1);
		
		mockMvc.perform(MockMvcRequestBuilders.get(
				"/api/tasks/{taskId}", 1))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.label", is("Doctor")))
			;
	}
	
	@Test
	public void testGetAllTasks() throws Exception {
		when(taskService.getTasks()).thenReturn(allTasks);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].label", is("Doctor")))
			.andExpect(jsonPath("$[2].label", is("Cinema")))
			;
	}
	
	@Test
	public void testUpdateTask() throws Exception {
		Task task = new Task();
		mockMvc.perform(MockMvcRequestBuilders.post("/api/calendars/{calendarId}/tasks/update", 11)
				.contentType(TestUtils.APPLICATION_JSON_UTF8)
				.content(TestUtils.convertObjectToJsonBytes(task)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)))
			;
	}

}

