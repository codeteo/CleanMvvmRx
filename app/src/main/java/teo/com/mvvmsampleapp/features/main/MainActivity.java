package teo.com.mvvmsampleapp.features.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import teo.com.mvvmsampleapp.MyApplication;
import teo.com.mvvmsampleapp.R;
import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.features.main.dagger.components.DaggerMainComponent;
import teo.com.mvvmsampleapp.features.main.dagger.modules.MainPresenterModule;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .applicationComponent(MyApplication.getApplicationComponent())
                .mainPresenterModule(new MainPresenterModule(this))
                .build()
                .inject(this);

        presenter.onLoadData();
    }

    @Override
    public void showData(List<Movie> movies) {
        Timber.i("movies size: %d", movies.size());
    }
}
