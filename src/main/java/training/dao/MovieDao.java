package training.dao;

import training.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {

    void createMovie(Movie movie);

    Optional<Movie> getMovieById(String movieId);

    List<Movie> getAllMovie();

    Optional<Movie> updateMovieById(Movie movie);

    Optional<Movie> deleteMovieById(String movieId);
}
