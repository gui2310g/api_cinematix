package com.example.api_cinematix.handler;

import com.example.api_cinematix.common.ConversorData;
import com.example.api_cinematix.domain.exception.ResourceBadRequestException;
import com.example.api_cinematix.domain.exception.ResourceNotFoundException;
import com.example.api_cinematix.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleResourceBadRequestException(ResourceBadRequestException ex) {
        ErrorResponse message = new ErrorResponse(
                ConversorData.convertDatetoDateHour(new Date()),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage()
        );

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse message = new ErrorResponse(
                ConversorData.convertDatetoDateHour(new Date()),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage()
        );

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleRequestException(Exception ex) {
        ErrorResponse message = new ErrorResponse(
                ConversorData.convertDatetoDateHour(new Date()),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage()
        );

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
