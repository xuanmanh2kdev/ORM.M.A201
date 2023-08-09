package training.dao;

import training.entity.MovieType;

import java.util.List;
import java.util.Optional;

public interface MovieTypeDao {
    void createMovieType(MovieType movieType);

    Optional<MovieType> getMovieTypeById(Integer movieTypeId);

    List<MovieType> getAllMovieType();

    Optional<MovieType> updateMovieTypeById(MovieType movieType);
}
