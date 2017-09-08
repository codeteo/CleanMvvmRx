package teo.com.mvvmsampleapp.features.main.dagger.modules;

import dagger.Module;
import dagger.Provides;
import teo.com.mvvmsampleapp.data.MoviesDataSource;
import teo.com.mvvmsampleapp.data.MoviesRepository;
import teo.com.mvvmsampleapp.data.source.Local;
import teo.com.mvvmsampleapp.data.source.Remote;
import teo.com.mvvmsampleapp.domain.GetMoviesUseCase;
import teo.com.mvvmsampleapp.domain.GetMoviesUseCaseImpl;
import teo.com.mvvmsampleapp.utils.ActivityScope;

/**
 *  Dagger Module class to provide dependencies for {@link GetMoviesUseCase}
 */

@Module
public class GetMoviesUseCaseModule {

    @ActivityScope
    @Provides
    MoviesDataSource providesMoviesRepository(@Local MoviesDataSource localDataSource,
                                          @Remote MoviesDataSource remoteDataSource) {
        return new MoviesRepository(localDataSource, remoteDataSource);
    }

    @ActivityScope
    @Provides
    GetMoviesUseCase providesGetMoviesUseCase(MoviesRepository repository) {
        return new GetMoviesUseCaseImpl(repository);
    }

}
