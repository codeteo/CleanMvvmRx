package teo.com.mvvmsampleapp.features.main;

import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * ViewModel for the list of movies in {@link MainActivity}
 */

public final class MovieViewModel {

    private Movie movie;

    public MovieViewModel(Movie movie) {
        this.movie = movie;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public String getOverview() {
        return movie.getOverview();
    }

}
