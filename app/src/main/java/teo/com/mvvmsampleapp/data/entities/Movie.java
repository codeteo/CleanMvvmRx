package teo.com.mvvmsampleapp.data.entities;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Main business model for the app.
 */

@AutoValue
public abstract class Movie implements Parcelable {
    public abstract String getId();
    public abstract String getTitle();
    public abstract String getOverview();
    public abstract String getVoteAverage();
    public abstract String getBackdropPath();
    public abstract String getAdult();
    public abstract String getOriginalLanguage();
    public abstract String getReleaseDate();
    public abstract String getOriginalTitle();
    public abstract String getVoteCount();
    public abstract String getPosterPath();
    public abstract String getVideo();
    public abstract String getPopularity();

    public static Builder builder() {
        return new AutoValue_Movie.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String id);
        public abstract Builder title(String title);
        public abstract Builder overview(String overview);
        public abstract Builder voteAverage(String voteAverage);
        public abstract Builder backdropPath(String backdropPath);
        public abstract Builder adult(String adult);
        public abstract Builder originalLanguage(String originalLanguage);
        public abstract Builder releaseDate(String releaseData);
        public abstract Builder originalTitle(String originalTitle);
        public abstract Builder voteCount(String voteCount);
        public abstract Builder posterPath(String posterPath);
        public abstract Builder video(String video);
        public abstract Builder popularity(String popularity);

        public abstract Movie build();
    }

    public static TypeAdapter<Movie> typeAdapter(Gson gson) {
        return new AutoValue_Movie.GsonTypeAdapter(gson);
    }

}
