package com.example.api_cinematix.dto;

import lombok.Data;

@Data
public class TmdbResponse {
    private MovieRequest[] results;
}
