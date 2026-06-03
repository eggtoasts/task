package com.example.task.domain.dto;

import com.example.task.domain.entities.TaskPriority;
import com.example.task.domain.entities.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

// Response body
// So no need for validation annotations.
public record TaskDto(   UUID id,
                         String title,
                         String description,
                         LocalDate dueDate,
                         TaskPriority priority,
                         TaskStatus status
) {
}
