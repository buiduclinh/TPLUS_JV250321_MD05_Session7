package com.example.ex.service.impl;

import com.example.ex.model.Movie;
import com.example.ex.repo.MovieDAO;
import com.example.ex.service.MovieIS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieS implements MovieIS {
    @Autowired
    MovieDAO movieDAO;

    @Override
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }

    @Override
    public Movie getMovie(int id) {
        return movieDAO.getMovie(id);
    }

    @Override
    public boolean addMovie(Movie movie) {
        return movieDAO.addMovie(movie);
    }

    @Override
    public boolean updateMovie(Movie movie) {
        return movieDAO.updateMovie(movie);
    }

    @Override
    public boolean deleteMovie(int id) {
        return movieDAO.deleteMovie(id);
    }
}
