package com.example.task.service;

import com.example.task.domain.CreateTaskRequest;
import com.example.task.domain.entities.Task;

public interface TaskService {
    Task createTask(CreateTaskRequest request);
}
