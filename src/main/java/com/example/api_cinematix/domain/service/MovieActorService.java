package com.example.api_cinematix.domain.service;

import com.example.api_cinematix.domain.util.TmdbUtil;
import com.example.api_cinematix.dto.request.MovieActorRequest;
import com.example.api_cinematix.dto.request.MovieRequest;
import com.example.api_cinematix.dto.response.TmdbCreditsResponse;
import com.example.api_cinematix.dto.response.TmdbMoviesCreditsResponse;

import com.example.api_cinematix.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class MovieActorService {

    private final RestTemplate restTemplate;

    private MovieMapper mapper;

    private TmdbUtil tmdbUtil;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieActorService(RestTemplate restTemplate, TmdbUtil tmdbUtil) {
        this.restTemplate = restTemplate;
        this.tmdbUtil = tmdbUtil;
    }

    public MovieActorRequest findActorById(Long id) {
        String url = "https://api.themoviedb.org/3/person/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieActorRequest.class);
    }

    public List<MovieRequest> findMoviesByActor(Long id) {
        String url = "https://api.themoviedb.org/3/person/" + id + "/movie_credits?api_key=" + apiKey;

        TmdbMoviesCreditsResponse response = restTemplate.getForObject(url, TmdbMoviesCreditsResponse .class);

        return response != null ? Arrays.stream(response.getCast())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieActorRequest> findActorsByMovie(Long id) {
        String url = "https://api.themoviedb.org/3/movie/" + id + "/credits?api_key=" + apiKey;

        TmdbCreditsResponse response = restTemplate.getForObject(url, TmdbCreditsResponse.class);

        return response != null ? Arrays.stream(response.getCast())
                .map(actor -> tmdbUtil.getActorsDetails(actor.getId())).toList() : List.of();
    }
}
