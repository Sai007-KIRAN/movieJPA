package com.example.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.movie.service.MovieJpaService;
import com.example.movie.model.Movie;

// Write your code here

@RestController
public class MovieController {
    @Autowired
    public MovieJpaService mjs;

    @GetMapping("/movies")
    public ArrayList<Movie> allMovie() {
        return mjs.allMovie();
    }

    @GetMapping("/movies/{movieId}")
    public Movie eachMovie(@PathVariable("movieId") int movieId) {
        return mjs.eachMovie(movieId);
    }

    @PostMapping("/movies")
    public Movie addmovie(@RequestBody Movie movie) {
        return mjs.addmovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return mjs.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        mjs.deleteMovie(movieId);
    }
}