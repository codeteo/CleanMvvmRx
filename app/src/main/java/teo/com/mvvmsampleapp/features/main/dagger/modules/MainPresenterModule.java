package teo.com.mvvmsampleapp.features.main.dagger.modules;

import dagger.Module;
import dagger.Provides;
import teo.com.mvvmsampleapp.features.main.MainMVP;
import teo.com.mvvmsampleapp.features.main.MainPresenter;
import teo.com.mvvmsampleapp.utils.ActivityScope;

/**
 * Dagger module which provides dependencies for {@link MainPresenter}
 */

@Module
public class MainPresenterModule {

    private MainMVP.View view;

    public MainPresenterModule(MainMVP.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    MainMVP.View providesMainView() {
        return view;
    }
}
