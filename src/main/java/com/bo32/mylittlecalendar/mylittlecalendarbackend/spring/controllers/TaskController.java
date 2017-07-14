package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.beans.ApiMessage;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Task;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.CalendarService;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value="/api/tasks/{taskId}", method=RequestMethod.GET)
	public Task getTask(@PathVariable long taskId) {
		Task task = taskService.getTask(taskId);
		return task;
	}
	
	@RequestMapping(value="/api/tasks", method=RequestMethod.GET)
	public List<Task> getAllTasks() {
		return taskService.getTasks();
	}
	
	@RequestMapping(value="/api/calendars/{calendarId}/tasks", method=RequestMethod.GET)
	public List<Task> getTasksByCalendar(
			@PathVariable long calendarId) {
		Calendar c = calendarService.getCalendar(calendarId);
		return taskService.getTasksByCalendar(c);
	}
	
	@RequestMapping(value="/api/calendars/{calendarId}/tasks/create", method=RequestMethod.POST)
	public ApiMessage createTask(
			@PathVariable long calendarId,
			@RequestBody final Task task) {
		taskService.createTask(task);
		return new ApiMessage(ApiMessage.SUCCESS, "Task successfully created.");
	}
	
	@RequestMapping(value="/api/calendars/{calendarId}/tasks/update", method=RequestMethod.POST)
	public ApiMessage updateTask(
			@PathVariable long calendarId,
			@RequestBody final Task task) {
		taskService.updateTask(task);
		return new ApiMessage(ApiMessage.SUCCESS, "Task successfully updated.");
	}

}
