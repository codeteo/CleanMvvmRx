package teo.com.mvvmsampleapp.features.main.dagger.modules;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import teo.com.mvvmsampleapp.data.source.remote.MoviesService;
import teo.com.mvvmsampleapp.utils.ActivityScope;

/**
 * Dagger Module that provides {@link MoviesService}.
 */

@Module
public class MoviesServiceModule {

    @ActivityScope
    @Provides
    MoviesService providesMovieService(Retrofit retrofit) {
        return retrofit.create(MoviesService.class);
    }

}
