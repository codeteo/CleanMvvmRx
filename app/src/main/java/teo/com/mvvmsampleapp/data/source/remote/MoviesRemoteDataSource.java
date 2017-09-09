package teo.com.mvvmsampleapp.data.source.remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import teo.com.mvvmsampleapp.data.MoviesDataSource;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.data.entities.MoviesNestedItemResponse;
import teo.com.mvvmsampleapp.data.entities.mappers.MovieMapper;
import teo.com.mvvmsampleapp.utils.schedulers.BaseSchedulerProvider;

/**
 * Concrete implementation of the remote data source
 */

public class MoviesRemoteDataSource implements MoviesDataSource {

    private MoviesService service;
    private BaseSchedulerProvider schedulerProvider;
    private String apiKey;

    @Inject
    public MoviesRemoteDataSource(MoviesService service,
                              BaseSchedulerProvider schedulerProvider, @Named("Api-Key") String apiKey) {
        this.service = service;
        this.schedulerProvider = schedulerProvider;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<List<Movie>> loadMovies() {
        return service.getMostPopular(apiKey)
                .map(moviesResponse -> {

                    List<Movie> movies = new ArrayList<>();

                    for (MoviesNestedItemResponse nestedItemResponse: moviesResponse.getResults()) {
                        movies.add(new MovieMapper().from(nestedItemResponse));
                    }

                    return movies;
                })
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }
}
