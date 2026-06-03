package com.example.task.controller;

import com.example.task.domain.CreateTaskRequest;
import com.example.task.domain.dto.CreateTaskRequestDTO;
import com.example.task.domain.dto.TaskDto;
import com.example.task.domain.entities.Task;
import com.example.task.mapper.TaskMapper;
import com.example.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//allows us to specify the base path for all endpoints in this task controller
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
    //we use these to get objects by the presentation layer (dtos)
    //and map them to objects so service layer can interact w it
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    //our endpoint :D represented by a method.
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDTO createTaskRequestDTO
    ){
        //turns DTO request into request object
        CreateTaskRequest createTaskRequest= taskMapper.fromDto(createTaskRequestDTO);

        Task task = taskService.createTask(createTaskRequest);

        //convert task entity to DTO
        TaskDto createdTaskDto = taskMapper.toDto(task);

        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }
}
