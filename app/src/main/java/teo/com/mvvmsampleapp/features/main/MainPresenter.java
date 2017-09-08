package teo.com.mvvmsampleapp.features.main;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import teo.com.mvvmsampleapp.domain.GetMoviesUseCase;
import timber.log.Timber;

/**
 * Presenter for {@link MainActivity}
 */

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GetMoviesUseCase moviesUseCase;

    private CompositeSubscription subscriptions;

    @Inject
    MainPresenter(MainMVP.View view, GetMoviesUseCase moviesUseCase) {
        this.view = view;
        this.moviesUseCase = moviesUseCase;
    }

    @Override
    public void onLoadData() {
        subscriptions = new CompositeSubscription();

        Subscription subscription =
                moviesUseCase.getMovies()
                    .subscribe(
                            movies -> view.showData(movies),
                           t -> Timber.i("error: %s", t.getStackTrace()));

        subscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        if (subscriptions.hasSubscriptions()) {
            subscriptions.clear();
        }
    }

}
