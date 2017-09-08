package teo.com.mvvmsampleapp.dagger.components;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import teo.com.mvvmsampleapp.MyApplication;
import teo.com.mvvmsampleapp.dagger.modules.ApplicationModule;
import teo.com.mvvmsampleapp.dagger.modules.NetworkModule;
import teo.com.mvvmsampleapp.utils.BaseUrlInterceptor;
import teo.com.mvvmsampleapp.utils.schedulers.BaseSchedulerProvider;

/**
 * Dagger Component builds the object graph for singleton scoped dependencies.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    /** exposed dependencies to downstream components (e.g. NetworkComponent) **/

    Application getApplication();

    SharedPreferences getSharedPreferences();

    HttpUrl baseUrl();

    Retrofit retrofit();

    // exposes Interceptor to use it for testing with mockWebServer
    BaseUrlInterceptor baseUrlInterceptor();

    BaseSchedulerProvider baseSchedulerProvider();

    @Named("Api-Key") String  getApiKey();
}