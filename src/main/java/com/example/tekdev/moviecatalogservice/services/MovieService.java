package com.example.tekdev.moviecatalogservice.services;

import com.example.tekdev.moviecatalogservice.models.Movie;
import com.example.tekdev.moviecatalogservice.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    public MovieService() {
        System.out.println("Movie service initiated");
    }

    public List<Movie> getAllMovies() {
        return moviesRepository.findAll();
    }

    public void addMovie(Movie movie) {
        moviesRepository.save(movie);
    }

    public void deleteMovie(String movieName) {
        moviesRepository.deleteById(movieName);
    }

    public Movie getMovie(String movieName) {
        Optional<Movie> movie = moviesRepository.findById(movieName);
        return movie.get();
    }
}
