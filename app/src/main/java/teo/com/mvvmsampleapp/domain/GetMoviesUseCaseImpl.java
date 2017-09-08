package teo.com.mvvmsampleapp.domain;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import teo.com.mvvmsampleapp.data.MoviesRepository;
import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * Concrete implementation for {@link GetMoviesUseCase}
 */

public class GetMoviesUseCaseImpl implements GetMoviesUseCase {

    private MoviesRepository repository;

    @Inject
    public GetMoviesUseCaseImpl(MoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        return repository.loadMovies();
    }
}
