package com.example.api_cinematix.dto.response;

import com.example.api_cinematix.dto.request.MovieRequest;
import lombok.Data;

@Data
public class TmdbMoviesCreditsResponse {
    private MovieRequest[] cast;
}
