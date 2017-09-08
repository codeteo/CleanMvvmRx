package teo.com.mvvmsampleapp.data.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Models the response of GET "/movies/popular" service
 */

public class MoviesResponse {
    @SerializedName("results") private MoviesNestedItemResponse[] results;
    @SerializedName("page") private int page;
    @SerializedName("total_pages") private int totalPages;
    @SerializedName("total_results") private int totalResults;

    public MoviesNestedItemResponse[] getResults() {
        return results;
    }

    public void setResults(MoviesNestedItemResponse[] results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}

