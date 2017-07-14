package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
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
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.CalendarService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CalendarController.class)
public class CalendarControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CalendarService calendarService;
	
	private List<Calendar> calendars;
	private Calendar calendar;
	
	@Before
	public void setUp() {
		calendar = new Calendar();
		calendar.setId(10);
		calendar.setName("Work");
		
		Calendar c = new Calendar();
		c.setId(11);
		c.setName("Free time");
		
		calendars = new ArrayList<Calendar>();
		calendars.add(calendar);
		calendars.add(c);
	}
	
	@Test
	public void testGetCalendar() throws Exception {		
		when(calendarService.getCalendar(10)).thenReturn(calendar);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/calendars/{calendarId}", 10))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.name", is("Work")));
	}
	
	@Test
	public void testCreateCalendar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/calendars/create")
				.contentType(TestUtils.APPLICATION_JSON_UTF8)
				.content(TestUtils.convertObjectToJsonBytes(calendar)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.status", is(ApiMessage.SUCCESS)));
	}
	
	@Test
	public void testGetAllCalendars() throws Exception {
		when(calendarService.getAllCalendars()).thenReturn(calendars);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/calendars"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(10)))
			.andExpect(jsonPath("$[1].name", is("Free time")))
		;
	}

}
