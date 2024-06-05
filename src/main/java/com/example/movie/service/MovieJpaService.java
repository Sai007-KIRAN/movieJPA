package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.repository.MovieRepository;
import com.example.movie.model.Movie;
import com.example.movie.repository.MovieJpaRepository;
// Write your code here

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    private MovieJpaRepository mjr;

    @Override
    public ArrayList<Movie> allMovie() {
        List<Movie> movie = mjr.findAll();
        ArrayList<Movie> allMovies = new ArrayList<>(movie);
        return allMovies;
    }

    @Override
    public Movie eachMovie(int movieId) {
        try {
            Movie each = mjr.findById(movieId).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addmovie(Movie movie) {
        mjr.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie update = mjr.findById(movieId).get();
            if (movie.getMovieName() != null) {
                update.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                update.setLeadActor(movie.getLeadActor());
            }
            mjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            mjr.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
