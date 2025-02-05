package com.example.api_cinematix.domain.service;

import com.example.api_cinematix.dto.MovieRequest;
import com.example.api_cinematix.dto.TmdbResponse;
import com.example.api_cinematix.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private RestTemplate restTemplate;

    private MovieMapper mapper;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MovieRequest> findPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findUpcomingMovies() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findTopRatedMovies() {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findNowPlayingMovies() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public MovieRequest findById(Long id) {
        String url = "https://api.themoviedb.org/3/movie/ " + id + "?api_key=" + apiKey;

        MovieRequest response = restTemplate.getForObject(url, MovieRequest.class);

        if (response == null) throw new RuntimeException("Movie not found in TMDB");

        return response;
    }

    public List<MovieRequest> findMoviesByTitle(String query) {
        String searchUrl = "https://api.themoviedb.org/3/search/movie?query=" + query + "&api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(searchUrl, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> getMoviesDetails(movie.getId())).toList() : List.of();
    }

    private MovieRequest getMoviesDetails(long movieId) {
        String detailUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(detailUrl, MovieRequest.class);
    }
}
