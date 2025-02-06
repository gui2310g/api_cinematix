package com.example.api_cinematix.dto.request;

import lombok.Data;

@Data
public class ActorRequest {
    private Long id;

    private String name;

    private Boolean adult;

    private String biography;

    private String birthday;

    private String deathday;

    private Integer gender;

    private String homepage;

    private String place_of_birth;

    private String profile_path;
}
