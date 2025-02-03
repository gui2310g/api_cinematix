package com.example.api_cinematix.dto;

import lombok.Data;

import java.util.List;

@Data
public class TmdbMovieResponse {
    private int page;
    private List<MovieRequest> results;
}
