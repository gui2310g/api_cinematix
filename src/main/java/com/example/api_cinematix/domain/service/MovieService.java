package com.example.api_cinematix.domain.service;

import com.example.api_cinematix.domain.util.TmdbUtil;
import com.example.api_cinematix.dto.request.MovieRequest;
import com.example.api_cinematix.dto.request.MovieVideoRequest;
import com.example.api_cinematix.dto.response.TmdbResponse;
import com.example.api_cinematix.dto.response.TmdbVideosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    private final TmdbUtil tmdbUtil;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieService(RestTemplate restTemplate, TmdbUtil tmdbUtil) {
        this.restTemplate = restTemplate;
        this.tmdbUtil = tmdbUtil;
    }

    public List<MovieRequest> findPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findUpcomingMovies() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findTopRatedMovies() {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieRequest> findNowPlayingMovies() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(url, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public MovieRequest findById(Long id) {
        String url = "https://api.themoviedb.org/3/movie/ " + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieRequest.class);
    }

    public List<MovieRequest> findMoviesByTitle(String query) {
        String searchUrl = "https://api.themoviedb.org/3/search/movie?query=" + query + "&api_key=" + apiKey;

        TmdbResponse response = restTemplate.getForObject(searchUrl, TmdbResponse.class);

        return response != null ? Arrays.stream(response.getResults())
                .map(movie -> tmdbUtil.getMoviesDetails(movie.getId())).toList() : List.of();
    }

    public List<MovieVideoRequest> findVideosByMovie(Long movieId) {
        String detailUrl = "https://api.themoviedb.org/3/movie/" + movieId + "/videos" + "?api_key=" + apiKey;

        TmdbVideosResponse response = restTemplate.getForObject(detailUrl, TmdbVideosResponse.class);

        return response != null ? Arrays.stream(response.getResults()).toList() : List.of();
    }
}
