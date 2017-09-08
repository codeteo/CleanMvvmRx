package teo.com.mvvmsampleapp.data.source.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import teo.com.mvvmsampleapp.data.entities.MoviesResponse;

/**
 * Retrofit interface for api calls.
 */

public interface MoviesService {

    @GET("movie/popular")
    Observable<MoviesResponse> getMostPopular(@Query("api_key") String apiKey);

    @GET("most/top_rated")
    Observable<MoviesResponse> getTopRated(@Query("api_key") String apiKey);

}
