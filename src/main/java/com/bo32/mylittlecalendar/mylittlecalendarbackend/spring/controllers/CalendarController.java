package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.beans.ApiMessage;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.CalendarService;

@RestController
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value="/api/calendars/{calendarId}", method=RequestMethod.GET)
	public Calendar getCalendar(Principal principal, @PathVariable("calendarId") int calendarId) {
		return calendarService.getCalendar(calendarId);
	}
	
	@RequestMapping(value="/api/calendars/create", method=RequestMethod.POST)
	public ApiMessage createCalendar(Principal principal, @RequestBody final Calendar calendar) {
		calendarService.createCalendar(calendar);
		return new ApiMessage(ApiMessage.SUCCESS, "Calendar " + calendar.getName() + " has been created.");
	}
	
	@RequestMapping(value="/api/calendars", method=RequestMethod.GET)
	public List<Calendar> getAllCalendars() {
		return calendarService.getAllCalendars();
	}

}
