package teo.com.mvvmsampleapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import teo.com.mvvmsampleapp.dagger.components.ApplicationComponent;
import teo.com.mvvmsampleapp.dagger.components.DaggerApplicationComponent;
import teo.com.mvvmsampleapp.dagger.modules.ApplicationModule;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Main class of the app.
 */

public class MyApplication extends Application{

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
        LeakCanary.install(this);

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
