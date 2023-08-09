package training.dao.impl;

import org.hibernate.Session;
import training.dao.MovieDao;
import training.entity.Movie;
import training.utils.XmlConnectionConfig;

import java.util.List;
import java.util.Optional;

public class MovieDaoImpl implements MovieDao {
    @Override
    public void createMovie(Movie movie) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(movie);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<Movie> getMovieById(String movieId) {
        try(Session session = XmlConnectionConfig.getSession()) {
            Movie movie = session.find(Movie.class, movieId);
            return Optional.ofNullable(movie);
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
        }
    }

    @Override
    public Optional<Movie> updateMovieById(Movie movie) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Movie movie2 = session.find(Movie.class, movie.getMovieId());
            if (movie2 == null) {
                return null;
            }
            movie2.setMovieId(movie.getMovieId());
            movie2.setActor(movie.getActor());
            movie2.setContent(movie.getContent());
            movie2.setDirector(movie.getDirector());
            movie2.setContent(movie.getContent());
            movie2.setDuration(movie.getDuration());
            movie2.setFromDate(movie.getFromDate());
            movie2.setToDate(movie.getToDate());
            movie2.setMovieNameVn(movie.getMovieNameVn());
            movie2.setMovieNameEng(movie.getMovieNameEng());
            movie2.setMovieProductionCompany(movie.getMovieProductionCompany());
            movie2.setSmallImage(movie.getSmallImage());
            movie2.setLargeImage(movie.getLargeImage());
            session.merge(movie2);
            session.getTransaction().commit();
            return Optional.of(movie);
        }
    }

    @Override
    public Optional<Movie> deleteMovieById(String movieId) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Movie movie = session.find(Movie.class, movieId);
            if (movie == null) {
                return null;
            }
            session.remove(movie);
            session.getTransaction().commit();
            return Optional.of(movie);
        }
    }
}
