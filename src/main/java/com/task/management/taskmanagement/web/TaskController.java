package com.task.management.taskmanagement.web;

import com.task.management.taskmanagement.model.Task;
import com.task.management.taskmanagement.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TaskController {
     @Autowired
	private TaskService service;

	@RequestMapping(value = "api/tasks", produces = "application/json", method = RequestMethod.GET)
	public List<Task> listTasks() {
		return service.getAllTask();
	}

	@RequestMapping(value = "api/tasks", produces = "application/json", method = RequestMethod.POST)
	public Task createTask(@RequestBody Task task) {
		return service.createTask(task);
	}

	@RequestMapping(value = "api/tasks/{id}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable("id") String id) {
		service.deleteTask(id);
	}
}
