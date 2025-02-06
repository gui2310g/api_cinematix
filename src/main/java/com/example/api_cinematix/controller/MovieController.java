package com.example.api_cinematix.controller;

import com.example.api_cinematix.domain.service.MovieService;
import com.example.api_cinematix.dto.request.MovieRequest;
import com.example.api_cinematix.dto.request.ActorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<MovieRequest> FindById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieRequest>> findMoviesByTitle(@RequestParam String query) {
        return ResponseEntity.ok(movieService.findMoviesByTitle(query));
    }

    @GetMapping("/credits/{id}")
    public ResponseEntity<List<ActorRequest>> findActorsByMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findActorsByMovie(id));
    }
}
