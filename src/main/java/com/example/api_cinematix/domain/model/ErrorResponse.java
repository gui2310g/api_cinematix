package com.example.api_cinematix.domain.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private String dataHora;

    private Integer status;

    private String titulo;

    private String mensagem;
}
