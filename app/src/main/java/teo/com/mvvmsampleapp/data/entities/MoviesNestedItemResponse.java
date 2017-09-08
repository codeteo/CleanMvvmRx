package teo.com.mvvmsampleapp.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Nested item type for {@link MoviesResponse}
 */

public class MoviesNestedItemResponse {
    @SerializedName("vote_average") private String voteAverage;
    @SerializedName("backdrop_path") private String backdropPath;
    @SerializedName("adult") private String adult;
    @SerializedName("id") private String id;
    @SerializedName("title") private String title;
    @SerializedName("overview") private String overview;
    @SerializedName("original_language") private String originalLanguage;
    @SerializedName("genre_ids") private String[] genreIds;
    @SerializedName("release_date") private String releaseDate;
    @SerializedName("original_title") private String originalTitle;
    @SerializedName("vote_count") private String voteCount;
    @SerializedName("poster_path") private String posterPath;
    @SerializedName("video") private String video;
    @SerializedName("popularity") private String popularity;

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(String[] genreIds) {
        this.genreIds = genreIds;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}
