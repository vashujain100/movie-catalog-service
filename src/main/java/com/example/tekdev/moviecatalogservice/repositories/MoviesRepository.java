package com.example.tekdev.moviecatalogservice.repositories;

import com.example.tekdev.moviecatalogservice.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, String> {
}
