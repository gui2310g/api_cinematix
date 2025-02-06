package com.example.api_cinematix.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean adult;

    private String biography;

    private String birthday;

    private String deathday;

    private Integer gender;

    @Column(name = "website")
    private String homepage;

    @Column(name = "born")
    private String place_of_birth;

    @Column(name = "poster")
    private String profile_path;
}
