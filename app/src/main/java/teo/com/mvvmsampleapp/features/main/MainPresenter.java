package teo.com.mvvmsampleapp.features.main;

import javax.inject.Inject;

import teo.com.mvvmsampleapp.domain.GetMoviesUseCase;
import timber.log.Timber;

/**
 * Presenter for {@link MainActivity}
 */

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private GetMoviesUseCase moviesUseCase;

    @Inject
    MainPresenter(MainMVP.View view, GetMoviesUseCase moviesUseCase) {
        this.view = view;
        this.moviesUseCase = moviesUseCase;
    }

    @Override
    public void onLoadData() {
        moviesUseCase.getMovies()
                .subscribe(
                        movies -> view.showData(movies),
                        t -> Timber.i("error: %s", t.getStackTrace()));
    }
}
