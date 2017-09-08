package teo.com.mvvmsampleapp.features.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import teo.com.mvvmsampleapp.MyApplication;
import teo.com.mvvmsampleapp.R;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.features.main.adapter.MoviesAdapter;
import teo.com.mvvmsampleapp.features.main.dagger.components.DaggerMainComponent;
import teo.com.mvvmsampleapp.features.main.dagger.modules.MainPresenterModule;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @BindView(R.id.rv_list) RecyclerView rvList;

    @Inject
    MainPresenter presenter;

    MoviesAdapter adapter;

    private ArrayList<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            initPresenter();
            presenter.onLoadData();
        } else {
            if (savedInstanceState.getParcelableArrayList("movies") != null) {
                movieList = new ArrayList<>();
                movieList.addAll(savedInstanceState.getParcelableArrayList("movies"));
                setDataToAdapter(movieList);
                if (presenter == null) {
                    initPresenter();
                }
                presenter.setMovieList(movieList);
            } else {
                if (presenter == null) {
                    initPresenter();
                }
                presenter.onLoadData();
            }
        }
    }

    private void initPresenter() {
        DaggerMainComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .mainPresenterModule(new MainPresenterModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("movies", presenter.getMovieList());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showData(List<Movie> movies) {
        Timber.i("movies size: %d", movies.size());

        setDataToAdapter(movies);
    }

    @Override
    public void showToastError() {
        Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
    }

    private void setDataToAdapter(List<Movie> movies) {
        adapter = new MoviesAdapter(movies);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unsubscribe();
        }
    }
}
