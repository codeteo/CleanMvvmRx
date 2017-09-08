package teo.com.mvvmsampleapp.features.main;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.domain.GetMoviesUseCase;
import timber.log.Timber;

/**
 * Presenter for {@link MainActivity}
 */

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GetMoviesUseCase moviesUseCase;

    private CompositeSubscription subscriptions;

    private ArrayList<Movie> moviesList;

    @Inject
    MainPresenter(MainMVP.View view, GetMoviesUseCase moviesUseCase) {
        this.view = view;
        this.moviesUseCase = moviesUseCase;
        moviesList = new ArrayList<>();
    }

    @Override
    public void onLoadData() {
        subscriptions = new CompositeSubscription();

        Subscription subscription =
                moviesUseCase.getMovies()
                    .subscribe(
                            movies -> {
                                view.showData(movies);
                                moviesList.addAll(movies);
                            },
                           t -> Timber.i("error: %s", t.getStackTrace()));

        subscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        if (subscriptions!=null && subscriptions.hasSubscriptions()) {
            subscriptions.clear();
        }
    }

    @Override
    public ArrayList<Movie> getMovieList() {
        return moviesList;
    }

    @Override
    public void setMovieList(ArrayList<Movie> movieList) {
        this.moviesList = movieList;
    }
}
