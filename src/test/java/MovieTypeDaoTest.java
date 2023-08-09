import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.MovieTypeDao;
import training.dao.impl.MovieTypeDaoImpl;
import training.entity.Movie;
import training.entity.MovieType;
import training.entity.Type;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MovieTypeDaoTest {

    static MovieTypeDao movieTypeDao;

    @BeforeAll
    static void beforeAll(){
        movieTypeDao = new MovieTypeDaoImpl();
    }

    @Test
    void create_Movie_Type_Success_Test() {
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

        movieTypeDao.createMovieType(movieType);
    }

    @Test
    void create_Movie_Type_Fail_Test() {
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
//        movieType.setMtDescription("Movie type description 01");
        movieTypes.add(movieType);

        movie.setMovieType(movieTypes);
        type.setMovieType(movieTypes);

        movieTypeDao.createMovieType(movieType);
    }

    @Test
    void get_Movie_Type_By_Id_Success_Test(Integer movieTypeId){
        assertNotNull(movieTypeDao.getMovieTypeById(movieTypeId));
    }

    @Test
    void get_Movie_Type_By_Id_Fail_Test(Integer movieTypeId){
        assertNull(movieTypeDao.getMovieTypeById(movieTypeId));
    }

    @Test
    void update_Movie_Type_By_Id_Success_Test(){
        MovieType movieType = new MovieType();
        movieType.setMovieTypeId(1);
        movieType.setMtDescription("Movie type description 01");
        assertNotNull(movieTypeDao.updateMovieTypeById(movieType));
    }

    @Test
    void update_Movie_Type_By_Id_Fail_Test(){
        MovieType movieType = new MovieType();
        movieType.setMovieTypeId(100);
        movieType.setMtDescription("Movie type description 01");
        assertNull(movieTypeDao.updateMovieTypeById(movieType));
    }

}
