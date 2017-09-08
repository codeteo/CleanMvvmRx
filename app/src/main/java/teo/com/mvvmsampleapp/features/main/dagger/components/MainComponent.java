package teo.com.mvvmsampleapp.features.main.dagger.components;

import dagger.Component;
import teo.com.mvvmsampleapp.dagger.components.ApplicationComponent;
import teo.com.mvvmsampleapp.features.main.MainActivity;
import teo.com.mvvmsampleapp.features.main.dagger.modules.GetMoviesUseCaseModule;
import teo.com.mvvmsampleapp.features.main.dagger.modules.MainPresenterModule;
import teo.com.mvvmsampleapp.features.main.dagger.modules.MoviesRepositoryModule;
import teo.com.mvvmsampleapp.features.main.dagger.modules.MoviesServiceModule;
import teo.com.mvvmsampleapp.utils.ActivityScope;

/**
 * Dagger Component for {@link MainActivity}.
 */

@ActivityScope
@Component( dependencies = {ApplicationComponent.class},
        modules = {MainPresenterModule.class, MoviesRepositoryModule.class,
                MoviesServiceModule.class, GetMoviesUseCaseModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

}
