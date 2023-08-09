import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import training.dao.MovieDao;
import training.dao.MovieTypeDao;
import training.dao.TypeDao;
import training.dao.impl.MovieDaoImpl;
import training.dao.impl.MovieTypeDaoImpl;
import training.dao.impl.TypeDaoImpl;
import training.entity.Movie;
import training.entity.MovieType;
import training.entity.Type;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class testAll {

    static MovieDao movieDao;
    static TypeDao typeDao;
    static MovieTypeDao movieTypeDao;

    @BeforeAll
    static void beforeAll(){
        movieDao = new MovieDaoImpl();
        typeDao = new TypeDaoImpl();
        movieTypeDao = new MovieTypeDaoImpl();
    }

    @Test
    void create_DB_Test() {
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

    void create_Movie_Test(){
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
    }

    @Test
    void get_Movie_By_Id_Test(){
        System.out.println(movieDao.getMovieById("1"));
    }

    @Test
    void get_All_Movie_Test(){
        System.out.println(movieDao.getAllMovie());
    }

    @Test
    void update_Movie_By_Id_Test(){
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
        movieDao.updateMovieById(movie);
    }

    @Test
    void delete_Movie_By_Id_Test(){
        movieDao.deleteMovieById("1");
    }

    @Test
    void get_Type_By_Id_Test(){
        System.out.println(typeDao.getTypeById(1));
    }

    @Test
    void get_All_Type_Test(){
        System.out.println(typeDao.getAllType());
    }

    @Test
    void update_Type_By_Id_Test(){
        Type type = new Type();
        type.setTypeId(1);
        type.setTypeName("Type 01");
        type.setTypeDescription("Type description 01");
        typeDao.updateTypeById(type);
    }

    @Test
    void delete_Type_By_Id_Test(){
        typeDao.deleteTypeById(1);
    }

    @Test
    void get_Movie_Type_By_Id_Test(Integer movieTypeId){
        System.out.println(movieTypeDao.getMovieTypeById(movieTypeId));
    }
}
