package com.example.api_cinematix.dto.response;

import com.example.api_cinematix.dto.request.MovieVideoRequest;
import lombok.Data;

@Data
public class TmdbVideosResponse {
    private Long id;
    private MovieVideoRequest[] results;
}
