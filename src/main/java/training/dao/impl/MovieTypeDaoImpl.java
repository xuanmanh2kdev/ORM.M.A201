package training.dao.impl;

import org.hibernate.Session;
import training.dao.MovieTypeDao;
import training.entity.MovieType;
import training.utils.XmlConnectionConfig;

import java.util.List;
import java.util.Optional;

public class MovieTypeDaoImpl implements MovieTypeDao {

    public void createMovieType(MovieType movieType){
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(movieType);
            session.getTransaction().commit();
        }
    }

    public Optional<MovieType> getMovieTypeById(Integer movieTypeId){
        try(Session session = XmlConnectionConfig.getSession()) {
            MovieType movieType = session.find(MovieType.class, movieTypeId);
            return Optional.ofNullable(movieType);
        }
    }

    public List<MovieType> getAllMovieType(){
       try(Session session = XmlConnectionConfig.getSession()) {
           return session.createQuery("SELECT m FROM MovieType m", MovieType.class).getResultList();
       }
    }

    public Optional<MovieType> updateMovieTypeById(MovieType movieType){
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            MovieType movieType2 = session.find(MovieType.class, movieType.getMovieTypeId());
            if (movieType2 == null) {
                return null;
            }
            session.merge(movieType2);
            session.getTransaction().commit();
            return Optional.of(movieType);
        }
    }


}
