package com.example.api_cinematix.domain.service;

import com.example.api_cinematix.dto.request.MovieActorRequest;
import com.example.api_cinematix.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieActorService {

    private final RestTemplate restTemplate;

    private MovieMapper mapper;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieActorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieActorRequest findActorById(Long id) {
        String url = "https://api.themoviedb.org/3/person/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieActorRequest.class);
    }
}
