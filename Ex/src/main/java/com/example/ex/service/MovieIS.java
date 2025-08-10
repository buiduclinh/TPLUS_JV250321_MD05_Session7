package com.example.ex.service;

import com.example.ex.model.Movie;

import java.util.List;

public interface MovieIS {
    List<Movie> getMovies();

    Movie getMovie(int id);

    boolean addMovie(Movie movie);

    boolean updateMovie(Movie movie);

    boolean deleteMovie(int id);
}
