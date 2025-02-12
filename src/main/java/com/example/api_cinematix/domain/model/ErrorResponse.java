package com.example.api_cinematix.domain.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private String dateHour;

    private Integer status;

    private String title;

    private String message;
}
