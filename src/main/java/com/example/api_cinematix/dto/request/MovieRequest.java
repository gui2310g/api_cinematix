package com.example.api_cinematix.dto.request;

import com.example.api_cinematix.domain.model.movieDetails.MovieGenre;
import com.example.api_cinematix.domain.model.movieDetails.MovieProductionCompany;
import lombok.Data;

import java.util.Set;

@Data
public class MovieRequest {
    private long id;

    private String backdrop_path;

    private String title;

    private String homepage;

    private String overview;

    private String original_language;

    private String poster_path;

    private Integer popularity;

    private String tagline;

    private String release_date;

    private Boolean video;

    private Double vote_average;

    private Set<MovieGenre> genres;

    private Set<MovieProductionCompany> production_companies;
}
