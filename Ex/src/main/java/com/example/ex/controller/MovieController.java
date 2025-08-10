package com.example.ex.controller;

import com.example.ex.model.Movie;
import com.example.ex.repo.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/movieServlet")
public class MovieController {

    @Autowired
    private MovieDAO movieDAO;

    @GetMapping("/getAllMovies")
    public String getAllMovies(Model model) {
        List<Movie> movieList = movieDAO.getMovies();
        model.addAttribute("movieList", movieList);
        return "movieHomeList";
    }

    @GetMapping("/addMovie")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie) {
        movieDAO.addMovie(movie);
        return "redirect:/movieServlet/getAllMovies";
    }

    @GetMapping("/parseMovie")
    public String parseMovie(@RequestParam int id, Model model) {
        Movie movie = movieDAO.getMovie(id);
        model.addAttribute("movie", movie);
        return "updateMovie";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@ModelAttribute Movie movie) {
        movieDAO.updateMovie(movie);
        return "redirect:/movieServlet/getAllMovies";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam int id) {
        movieDAO.deleteMovie(id);
        return "redirect:/movieServlet/getAllMovies";
    }
}
