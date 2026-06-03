package com.example.task.mapper;


import com.example.task.domain.CreateTaskRequest;
import com.example.task.domain.dto.CreateTaskRequestDTO;
import com.example.task.domain.dto.TaskDto;
import com.example.task.domain.entities.Task;

// maps our task class to taskDTO
public interface TaskMapper {
    //dto -> request
    CreateTaskRequest fromDto(CreateTaskRequestDTO dto);

    //task entity -> dto
    TaskDto toDto(Task task);
}
