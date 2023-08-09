import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.MovieDao;
import training.dao.impl.MovieDaoImpl;
import training.entity.Movie;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MovieDaoTest {

    static MovieDao movieDao;

    @BeforeAll
    static void beforeAll(){
        movieDao = new MovieDaoImpl();
    }

    @Test
    void create_Movie_Success_Test() {
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

        movieDao.createMovie(movie);
    }

    @Test
    void create_Movie_Fail_Test() {
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
//        movie.setVersion("Movie 01");
        assertThrows(PersistenceException.class,
                () -> movieDao.createMovie(movie));
    }

    @Test
    void get_Movie_By_Id_Success_Test(){
        assertNotNull(movieDao.getMovieById("1"));
    }

    @Test
    void get_Movie_By_Id_Fail_Test(){
        assertNull(movieDao.getMovieById("100"));
    }

    @Test
    void get_All_Movie_Success_Test(){
        assertNotNull(movieDao.getAllMovie());
    }

    @Test
    void get_All_Movie_Fail_Test(){
        assertNull(movieDao.getAllMovie());
    }

    @Test
    void update_Movie_By_Id_Success_Test(){
        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setMovieNameVn("Movie 01");
        movie.setLargeImage("https://image.tmdb.org/t/p/w500/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg");
        movie.setContent("Movie 01");
        movie.setDuration(120.0);
        movie.setMovieNameEng("Movie 01");
        movie.setMovieProductionCompany("Movie 01");
        movie.setDirector("Movie 01");
        movie.setActor("Movie 01");
        movie.setFromDate(LocalDate.parse("2021-01-01"));
        movie.setToDate(LocalDate.parse("2021-01-01"));
        assertNotNull(movieDao.updateMovieById(movie));
    }

    @Test
    void update_Movie_By_Id_Fail_Test(){
        Movie movie = new Movie();
        movie.setMovieId("1");
        movie.setMovieNameVn("Movie 01");
        movie.setLargeImage("https://image.tmdb.org/t/p/w500/8Y43POKjjKDGI9MH89NW0NAzzp8.jpg");
        movie.setContent("Movie 01");
        movie.setDuration(120.0);
        movie.setMovieNameEng("Movie 01");
        movie.setMovieProductionCompany("Movie 01");
        movie.setDirector("Movie 01");
        movie.setActor("Movie 01");
        movie.setFromDate(LocalDate.parse("2021-01-01"));
//        movie.setToDate(LocalDate.parse("2021-01-01"));
        assertNotNull(movieDao.updateMovieById(movie));
    }

    @Test
    void delete_Movie_By_Id_Success_Test(){
        assertNotNull(movieDao.deleteMovieById("1"));
    }

    @Test
    void delete_Movie_By_Id_Fail_Test(){
        assertNull(movieDao.deleteMovieById("100"));
    }

}
