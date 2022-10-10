package com.task.management.taskmanagement.web;

import com.task.management.taskmanagement.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public List<Task> getAllTask();

    public Task createTask(Task task);
    public void deleteTask(String id);
}
