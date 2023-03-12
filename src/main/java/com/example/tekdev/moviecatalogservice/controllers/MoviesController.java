package com.example.tekdev.moviecatalogservice.controllers;

import com.example.tekdev.moviecatalogservice.models.Movie;
import com.example.tekdev.moviecatalogservice.models.MovieList;
import com.example.tekdev.moviecatalogservice.services.MovieService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("all")
    public MovieList getAllMovies() {
        MovieList movieList = new MovieList();
        movieList.setMovieList(movieService.getAllMovies());
        return movieList;
    }

    @PostMapping("addMovie")
    public void addMovie(@RequestBody Movie movie) {
        System.out.println(movie.getMovieName());
        movieService.addMovie(movie);
        System.out.println("Movie added successfully!!");
    }

    @DeleteMapping("deleteMovie")
    public void deleteMovie(@RequestBody MovieName movieName) {
        movieService.deleteMovie(movieName.getMovieName());
        System.out.println("Movie Deleted Successfully!!");
    }

    @RequestMapping("{movieName}")
    public Movie getMovie(@PathVariable String movieName){
        return movieService.getMovie(movieName);
    }

    @Data
    static class MovieName {
        private String movieName;
    }
}
