package com.task.management.taskmanagement.web;

import com.task.management.taskmanagement.model.Task;
import com.task.management.taskmanagement.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component
public class TaskServiceImpl implements  TaskService{


    private TaskRepository repository;




    @Override
    public List<Task> getAllTask() {
        return repository.findAll();
    }

    @Override
    public Task createTask(Task task) {
     return  repository.insert(task);
    }

    @Override
    public void deleteTask(String id) {
        repository.delete(id);

    }
    @Bean
    public TaskRepository getRepository() {
        return repository;
    }
}
