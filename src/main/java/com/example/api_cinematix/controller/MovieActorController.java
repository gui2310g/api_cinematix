package com.example.api_cinematix.controller;

import com.example.api_cinematix.domain.service.MovieActorService;
import com.example.api_cinematix.dto.request.MovieActorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieActorRequest> findActorById(@PathVariable Long id) {
        return ResponseEntity.ok(movieActorService.findActorById(id));
    }
}
