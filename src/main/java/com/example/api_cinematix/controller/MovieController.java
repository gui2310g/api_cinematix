package com.example.api_cinematix.controller;

import com.example.api_cinematix.domain.service.MovieService;
import com.example.api_cinematix.dto.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /* movies list */
    @GetMapping("/popular")
    public ResponseEntity<List<MovieRequest>> FindPopularMovies() {
        return ResponseEntity.ok(movieService.findPopularMovies());
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<MovieRequest>> FindUpcomingMovies() {
        return ResponseEntity.ok(movieService.findUpcomingMovies());
    }

    @GetMapping("/toprated")
    public ResponseEntity<List<MovieRequest>> FindTopRatedMovies() {
        return ResponseEntity.ok(movieService.findTopRatedMovies());
    }

    @GetMapping("/nowplaying")
    public ResponseEntity<List<MovieRequest>> FindNowPlayingMovies() {
        return ResponseEntity.ok(movieService.findNowPlayingMovies());
    }
}
