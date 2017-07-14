package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;

@Repository("calendarDAO")
public class CalendarDAOImpl implements CalendarDAO {
	
	@Override
	public Calendar getCalendar(long calendarId) {
		return null;
	}

	@Override
	public List<Calendar> getAllCalendars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCalendar() {
		// TODO Auto-generated method stub
		
	}
}
