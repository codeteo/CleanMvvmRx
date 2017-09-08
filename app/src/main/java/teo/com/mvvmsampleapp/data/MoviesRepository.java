package teo.com.mvvmsampleapp.data;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.data.source.Local;
import teo.com.mvvmsampleapp.data.source.Remote;

/**
 * Concrete implementation of {@link MoviesDataSource} to load data
 * from the data sources.
 */

public class MoviesRepository implements MoviesDataSource {

    private MoviesDataSource localDataSource;
    private MoviesDataSource remoteDataSource;

    @Inject
    public MoviesRepository(@Local MoviesDataSource localDataSource, @Remote MoviesDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> loadMovies() {
        return remoteDataSource.loadMovies();
    }
}
