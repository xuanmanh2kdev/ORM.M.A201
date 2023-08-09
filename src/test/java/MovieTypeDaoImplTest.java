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

import static org.junit.jupiter.api.Assertions.*;

public class MovieTypeDaoImplTest {

    static MovieTypeDao movieTypeDao;

    @BeforeAll
    static void beforeAll(){
        movieTypeDao = new MovieTypeDaoImpl();
    }

    @Test
    void get_Movie_Type_By_Id_Success_Test(){
        assertNotNull(movieTypeDao.getMovieTypeById(1));
    }

    @Test
    void get_Movie_Type_By_Id_Fail_Test(){
        assertNull(movieTypeDao.getMovieTypeById(100));
    }

    @Test
    void get_All_Movie_Type_Success_Test(){
        assertTrue(movieTypeDao.getAllMovieType().size() > 0);
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
