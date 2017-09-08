package teo.com.mvvmsampleapp.dagger.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import teo.com.mvvmsampleapp.Constants;
import teo.com.mvvmsampleapp.utils.BaseUrlInterceptor;
import teo.com.mvvmsampleapp.utils.ForTestingPurposes;

/**
 * Dagger Module which builds Singleton dependencies.
 */
@Module
public class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL);

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    @ForTestingPurposes
    static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor(Constants.BASE_URL);
    }

    @Provides
    @Singleton
    @Named("Api-Key")
    String providesApiKey() {
        return Constants.API_KEY;
    }

}
