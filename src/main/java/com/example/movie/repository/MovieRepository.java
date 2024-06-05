package com.example.movie.repository;

import com.example.movie.model.Movie;
import java.util.*;

public interface MovieRepository {
    ArrayList<Movie> allMovie();

    Movie eachMovie(int movieId);

    Movie addmovie(Movie movie);

    Movie updateMovie(int movieId, Movie movie);

    void deleteMovie(int movieId);
}