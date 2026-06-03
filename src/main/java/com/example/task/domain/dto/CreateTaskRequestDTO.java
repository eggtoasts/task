package com.example.task.domain.dto;

import com.example.task.domain.entities.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDTO(
        @NotBlank
        @Length(max=255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        String description,
        //makes sure date is either the current date or future
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE_FUTURE)
        @Nullable
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY)
        TaskPriority priority
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be less than 255 letters.";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = "Description must be less than 1000 letters.";
    private static final String ERROR_MESSAGE_DUE_DATE_FUTURE = "Due date must be in the future or present";
    private static final String ERROR_MESSAGE_PRIORITY = "Priority must be provided";
}
