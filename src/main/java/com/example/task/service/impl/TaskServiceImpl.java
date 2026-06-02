package com.example.task.service.impl;

import com.example.task.domain.CreateTaskRequest;
import com.example.task.domain.entities.Task;
import com.example.task.domain.entities.TaskStatus;
import com.example.task.repository.TaskRepository;
import com.example.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskServiceImpl implements TaskService {

    //automatically autowired!! (DI)
    //makes changes to our DB.
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        //time and date right now
        Instant now = Instant.now();
        Task newTask = new Task(
                now,
                now,
                request.priority(),
                TaskStatus.OPEN,
                request.dueDate(),
                request.description(),
                request.title(),
                null //hibernates generates the ID for us.
        );

        taskRepository.save(newTask);

        return newTask;
    }
}
