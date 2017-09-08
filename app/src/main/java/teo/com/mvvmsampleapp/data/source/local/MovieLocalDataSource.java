package teo.com.mvvmsampleapp.data.source.local;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import teo.com.mvvmsampleapp.data.MoviesDataSource;
import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * Concrete implementation of the local data source.
 */

public class MovieLocalDataSource implements MoviesDataSource {

    @Inject
    public MovieLocalDataSource() {
    }

    @Override
    public Observable<List<Movie>> loadMovies() {
        return null;
    }
}
