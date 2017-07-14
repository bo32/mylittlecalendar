package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories;

import java.util.List;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;

public interface CalendarDAO {
	
	public Calendar getCalendar(long calendarId);

	public List<Calendar> getAllCalendars();

	public void createCalendar();

}
