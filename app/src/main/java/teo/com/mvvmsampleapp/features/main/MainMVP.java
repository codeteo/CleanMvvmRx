package teo.com.mvvmsampleapp.features.main;

import java.util.ArrayList;
import java.util.List;

import teo.com.mvvmsampleapp.data.entities.Movie;

/**
 * Contract class for {@link MainActivity}
 */

public interface MainMVP {

    interface View {

        void showData(List<Movie> movies) ;

    }

    interface Presenter {

        void onLoadData();

        void unsubscribe();

        ArrayList<Movie> getMovieList();

        void setMovieList(ArrayList<Movie> movieList);
    }

}
