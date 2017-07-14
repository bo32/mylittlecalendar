package com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Calendar;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.entities.Task;
import com.bo32.mylittlecalendar.mylittlecalendarbackend.spring.repositories.TaskDAO;

@Service
public class TaskService {

	@Autowired
	private TaskDAO taskDAO;
	
	public void createTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	public Task getTask(long taskId) {
		return null;
	}

	public List<Task> getTasks() {
		return null;
	}

	public List<Task> getTasksByCalendar(Calendar c) {
		return null;
	}

	public void updateTask(Task task) {
		taskDAO.updateTask(task);
	}

}
