package com.example.api_cinematix.domain.model;

import com.example.api_cinematix.domain.model.movieDetails.Movie;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "created")
    private Date created_at;

    @ManyToMany
    @JoinTable(name = "moviesList",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idMovie"))
    private Set<Movie> moviesList;
}
