package com.example.api_cinematix.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MovieGenreRequest {
    private Long id;

    private String name;

    @JsonIgnore
    private MovieRequest movie;
}
