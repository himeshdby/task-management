package com.task.management.taskmanagement.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(exclude = {"id"})
@Builder
@ToString
@Document(collection="task")
public class Task {

	@Id
	@Getter
	@Setter
	private String id;

	@Indexed(unique = true)
	@Getter
	@Setter
	private String text;

	@Getter
	@Setter
	private String priority;


	public Task() {
	}

	public Task(@NonNull String text, @NonNull String content) {
		this.text = text;
		this.priority = priority;
	}

	public Task(String id, @NonNull String text, @NonNull String priority) {
		this.id = id;
		this.priority = priority;
		this.text = text;
	}
}
