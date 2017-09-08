package teo.com.mvvmsampleapp.domain;

import java.util.List;

import rx.Observable;
import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * Use Case class for get movies feature.
 */

public interface GetMoviesUseCase {
    Observable<List<Movie>> getMovies();
}
