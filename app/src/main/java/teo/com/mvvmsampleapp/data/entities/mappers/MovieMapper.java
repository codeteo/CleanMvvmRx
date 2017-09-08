package teo.com.mvvmsampleapp.data.entities.mappers;

import teo.com.mvvmsampleapp.data.entities.Movie;
import teo.com.mvvmsampleapp.data.entities.MoviesNestedItemResponse;

/**
 * Helper class to map data transfer objects to business objects.
 */

public class MovieMapper {

    public MovieMapper() {
    }

    public Movie from(MoviesNestedItemResponse nestedItem) {
        return Movie.builder().id(nestedItem.getId())
                .title(nestedItem.getTitle()).overview(nestedItem.getOverview())
                .voteAverage(nestedItem.getVoteAverage()).backdropPath(nestedItem.getBackdropPath())
                .adult(nestedItem.getAdult()).originalLanguage(nestedItem.getOriginalLanguage())
                .releaseDate(nestedItem.getReleaseDate()).originalTitle(nestedItem.getOriginalTitle())
                .voteCount(nestedItem.getVoteCount()).posterPath(nestedItem.getPosterPath())
                .video(nestedItem.getVideo()).popularity(nestedItem.getPopularity())
                .build();
    }

}
