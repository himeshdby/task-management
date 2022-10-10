package com.task.management.taskmanagement;

import com.task.management.taskmanagement.model.Task;
import com.task.management.taskmanagement.repo.TaskRepository;
import com.task.management.taskmanagement.web.TaskController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.DoubleStream.builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {

	@InjectMocks
	TaskController controller;

	@Mock
	TaskRepository repo;

	@Test
	public void returnAllTasks() {
		Task firstTask = Task.builder().subject("first").content("content").build();
		Task secondTask = Task.builder().subject("second").content("content").build();
		List<Task> tasks = asList(firstTask, secondTask);
		given(repo.findAll()).willReturn(tasks);

		List<Task> result = controller.listTasks();

		assertThat(result).isEqualTo(tasks);
	}

	@Test
	public void deleteTask() {
		controller.deleteTask("id");

		verify(repo).delete("id");
	}

	@Test
	public void createTask() {
		Task task = Task.builder().subject("a task").content("sample content").build();
		given(repo.insert(eq(task))).willReturn(task);

		//Task result = controller.createTask("a task");

		//assertThat(result).isEqualTo(task);
	}

}