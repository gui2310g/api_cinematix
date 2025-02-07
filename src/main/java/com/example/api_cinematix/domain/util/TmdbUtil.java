package com.example.api_cinematix.domain.util;

import com.example.api_cinematix.dto.request.MovieActorRequest;
import com.example.api_cinematix.dto.request.MovieRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TmdbUtil {

    private final RestTemplate restTemplate;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public TmdbUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieRequest getMoviesDetails(long movieId) {
        String detailUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(detailUrl, MovieRequest.class);
    }

    public MovieActorRequest getActorsDetails(long actorId) {
        String detailUrl = "https://api.themoviedb.org/3/person/" + actorId + "?api_key=" + apiKey;
        return restTemplate.getForObject(detailUrl, MovieActorRequest.class);
    }
}
