package com.example.api_cinematix.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MovieProductionCompanyRequest {
    private Long id;

    private String logo_path;

    private String name;

    private String origin_country;

    @JsonIgnore
    private MovieRequest movie;
}
