package teo.com.mvvmsampleapp.features.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.domain.GetMoviesUseCase;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by css on 9/8/17.
 */

public class MainPresenterTest {

    private MainPresenter presenter;

    @Mock
    private MainMVP.View view;

    @Mock
    private GetMoviesUseCase moviesUseCase;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        presenter = new MainPresenter(view, moviesUseCase);
    }

    @Test
    public void onLoadData_withSuccess_shouldShowData() throws Exception {
        // given
        when(moviesUseCase.getMovies()).thenReturn(Observable.just(movieList()));
        TestSubscriber<List<Movie>> testSubscriber = new TestSubscriber<>();
        moviesUseCase.getMovies().subscribe(testSubscriber);

        // when
        presenter.onLoadData();

        verify(view).showData(movieList());

        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(singletonList(movieList()));
    }

    @Test
    public void onLoadData_withFailure_shouldShowToastError() throws Exception {
        // given
        when(moviesUseCase.getMovies()).thenReturn(Observable.error(new IOException()));
        TestSubscriber<List<Movie>> testSubscriber = new TestSubscriber<>();
        moviesUseCase.getMovies().subscribe(testSubscriber);

        // when
        presenter.onLoadData();

        verify(view).showToastError();

    }

    private List<Movie> movieList() {
        List<Movie> movieList = new ArrayList<>();

        Movie movie1 = Movie.builder().id("10")
                .title("title").overview("overview")
                .voteAverage("100").backdropPath("backdrop")
                .adult("adult").originalLanguage("lang")
                .releaseDate("date").originalTitle("title2")
                .voteCount("100").posterPath("path")
                .video("video").popularity("pop")
                .build();

        Movie movie2 = Movie.builder().id("11")
                .title("title2").overview("overview2")
                .voteAverage("100").backdropPath("backdrop2")
                .adult("adult").originalLanguage("lang")
                .releaseDate("date").originalTitle("title2")
                .voteCount("100").posterPath("path")
                .video("video").popularity("pop")
                .build();

        movieList.add(movie1);
        movieList.add(movie2);

        return movieList;
    }

}