package com.example.api_cinematix.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "movies")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovie")
    private long id;

    @Column(name = "backdrop")
    private String backdrop_path;

    private String title;

    @Column(name = "website")
    private String homepage;

    @Column(name = "description")
    private String overview;

    @Column(name = "language")
    private String original_language;

    @Column(name = "poster")
    private String poster_path;

    private Integer popularity;

    private String tagline;

    @Column(name = "release")
    private String release_date;

    private Boolean video;

    @Column(name = "average")
    private Double vote_average;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MovieGenre> genres;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MovieProductionCompany> production_companies;
}
