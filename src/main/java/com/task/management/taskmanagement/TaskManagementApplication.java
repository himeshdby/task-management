package com.task.management.taskmanagement;

import com.task.management.taskmanagement.mongo.MongoConfiguration;
import com.task.management.taskmanagement.repo.TaskRepository;
import com.task.management.taskmanagement.web.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class , HibernateJpaAutoConfiguration.class})
@ComponentScan({"com.*"})
@Configuration
@EnableJpaRepositories(basePackageClasses = {TaskRepository.class, MongoDbFactory.class, MongoTemplate.class})
@PropertySource({"classpath:application.properties"})
public class TaskManagementApplication  {

	@Autowired
	TaskService service;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
