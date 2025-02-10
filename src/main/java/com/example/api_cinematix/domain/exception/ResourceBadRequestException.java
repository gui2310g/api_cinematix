package com.example.api_cinematix.domain.exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String message) {
        super(message);
    }
}
