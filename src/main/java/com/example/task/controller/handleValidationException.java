package com.example.task.controller;


import com.example.task.domain.dto.ErrorResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//tells spring to look here for exception handling methods
@RestControllerAdvice
public class handleValidationException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> HandleValidationException(
            MethodArgumentNotValidException ex) {

        // Get the first validation error message
        String errorMessage =
                ex.getBindingResult().getFieldErrors().stream()
                        .findFirst()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .orElse("Validation failed.");

        // Create an ErrorResponseDto using the error message.
        ErrorResponseDto errorDto = new ErrorResponseDto(errorMessage);

        // Return the ErrorResponseDto in the response body
        //  with an HTTP 400 BAD REQUEST.
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);

    }
}
