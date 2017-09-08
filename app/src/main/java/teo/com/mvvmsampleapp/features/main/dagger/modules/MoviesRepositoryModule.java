package teo.com.mvvmsampleapp.features.main.dagger.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import teo.com.mvvmsampleapp.data.MoviesDataSource;
import teo.com.mvvmsampleapp.data.MoviesRepository;
import teo.com.mvvmsampleapp.data.source.Local;
import teo.com.mvvmsampleapp.data.source.Remote;
import teo.com.mvvmsampleapp.data.source.local.MovieLocalDataSource;
import teo.com.mvvmsampleapp.data.source.remote.MoviesRemoteDataSource;
import teo.com.mvvmsampleapp.data.source.remote.MoviesService;
import teo.com.mvvmsampleapp.utils.ActivityScope;
import teo.com.mvvmsampleapp.utils.schedulers.BaseSchedulerProvider;

/**
 * Dagger Module class to provide dependencies for {@link MoviesRepository}.
 */

@Module
public class MoviesRepositoryModule {

    @Local
    @ActivityScope
    @Provides
    MoviesDataSource providesLocalDataSource() {
        return new MovieLocalDataSource();
    }

    @Remote
    @ActivityScope
    @Provides
    MoviesDataSource providesRemoteDataSource(MoviesService service,
                                                    BaseSchedulerProvider schedulerProvider, @Named("Api-Key") String apiKey) {
        return new MoviesRemoteDataSource(service, schedulerProvider, apiKey);
    }

}
