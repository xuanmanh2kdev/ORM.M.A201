import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.MovieDao;
import training.dao.TypeDao;
import training.dao.impl.MovieDaoImpl;
import training.dao.impl.TypeDaoImpl;
import training.entity.Movie;
import training.entity.MovieType;
import training.entity.Type;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CreateAllTest {

    static MovieDao movieDao;
    static TypeDao typeDao;

    @BeforeAll
    static void beforeAll(){
        movieDao = new MovieDaoImpl();
        typeDao = new TypeDaoImpl();
    }

    @Test
    void create_DB_Success_Test() {
        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setMovieNameVn("Movie 01");
        movie.setLargeImage("https://image.tmdb.org/t/p/w500/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg");
        movie.setSmallImage("https://image.tmdb.org/t/p/w500/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg");
        movie.setContent("Movie 01");
        movie.setDuration(120.0);
        movie.setMovieNameEng("Movie 01");
        movie.setMovieProductionCompany("Movie 01");
        movie.setDirector("Movie 01");
        movie.setActor("Movie 01");
        movie.setFromDate(LocalDate.parse("2021-01-01"));
        movie.setToDate(LocalDate.parse("2021-01-01"));
        movie.setVersion("Movie 01");

        Type type = new Type();
        type.setTypeName("Type 01");
        type.setTypeDescription("Type description 01");

        Set<MovieType> movieTypes = new HashSet<>();
        MovieType movieType = new MovieType();
        movieType.setMovie(movie);
        movieType.setType(type);
        movieType.setMtDescription("Movie type description 01");
        movieTypes.add(movieType);

        movie.setMovieType(movieTypes);
        type.setMovieType(movieTypes);

        movieDao.createMovie(movie);
        typeDao.createType(type);
    }
}
