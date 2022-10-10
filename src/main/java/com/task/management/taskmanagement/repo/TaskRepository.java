package com.task.management.taskmanagement.repo;

import com.task.management.taskmanagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface TaskRepository extends MongoRepository<Task, String> {
    Task insert(Task task);

    void delete(String id);
}
