package com.example.api_cinematix.dto.request;

import lombok.Data;

@Data
public class MovieVideoRequest {
    private String id;

    private String name;

    private String key;

    private String site;

    private String type;

    private String iso_639_1;

    private String iso_3166_1;

    private Integer size;

    private String published_at;

    private Boolean official;
}
