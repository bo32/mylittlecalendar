package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories.CalendarDAO;

@Service
public class CalendarService {
	
	@Autowired
	public CalendarDAO calendarDAO;
	
	public Calendar getCalendar(long calendarId) {
		return calendarDAO.getCalendar(calendarId);
	}

	public List<Calendar> getAllCalendars() {
		return calendarDAO.getAllCalendars();
	}

	public void createCalendar(Calendar calendar) {
		calendarDAO.createCalendar();
	}

}
