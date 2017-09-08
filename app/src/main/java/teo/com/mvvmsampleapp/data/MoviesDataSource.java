package teo.com.mvvmsampleapp.data;

import java.util.List;

import rx.Observable;
import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * Main entry point for accessing movies.
 */

public interface MoviesDataSource {

    Observable<List<Movie>> loadMovies();

}
