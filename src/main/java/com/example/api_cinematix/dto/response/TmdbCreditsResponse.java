package com.example.api_cinematix.dto.response;

import com.example.api_cinematix.dto.request.MovieActorRequest;
import lombok.Data;

@Data
public class TmdbCreditsResponse {
    private String id;
    private MovieActorRequest[] cast;
}
