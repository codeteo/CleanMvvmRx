package teo.com.mvvmsampleapp;

/**
 * Contains common values for the app.
 */

public final class Constants {

    public static final String API_KEY = BuildConfig.API_KEY;

    public static final String BASE_URL = "http://api.themoviedb.org/3/";

    /** images url**/
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
    public final static String IMAGE_SIZE_W185 = "w185/";
    public final static String IMAGE_SIZE_W342 = "w342/";
    public final static String IMAGE_SIZE_W500 = "w500/";
    public final static String IMAGE_SIZE_W780 = "w780/";

    public static String appendImageUrl(String imgUrl) {
        if (imgUrl == null) return null;
        return BASE_IMAGE_URL + IMAGE_SIZE_W780 + imgUrl;
    }
}