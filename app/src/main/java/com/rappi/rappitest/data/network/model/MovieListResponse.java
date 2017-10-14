package com.rappi.rappitest.data.network.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.rappi.rappitest.utils.ErrorHandlerUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieListResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieResponse> results;

    public List<MovieResponse> getResults() {
        if (results == null) {
            results = new ArrayList<>();
        }
        return results;
    }

    public static class MovieResponse {
        @SerializedName("vote_count")
        private int voteCount;
        @SerializedName("id")
        private int id;
        @SerializedName("video")
        private boolean video;
        @SerializedName("vote_average")
        private double voteAverage;
        @SerializedName("title")
        private String title;
        @SerializedName("popularity")
        private double popularity;
        @SerializedName("poster_path")
        private String posterPath;
        @SerializedName("original_language")
        private String originalLanguage;
        @SerializedName("original_title")
        private String originalTitle;
        @SerializedName("genre_ids")
        private List<Integer> genreIds;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("adult")
        private boolean adult;
        @SerializedName("overview")
        private String overview;
        @SerializedName("release_date")
        private String releaseDate;

        public int getVoteCount() {
            return voteCount;
        }

        public int getId() {
            return id;
        }

        public boolean getVideo() {
            return video;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        @NonNull
        public String getTitle() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(title);
        }

        public double getPopularity() {
            return popularity;
        }

        @NonNull
        public String getPosterPath() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(posterPath);
        }

        @NonNull
        public String getOriginalLanguage() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(originalLanguage);
        }

        @NonNull
        public String getOriginalTitle() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(originalTitle);
        }

        public List<Integer> getGenreIds() {
            if (genreIds == null) {
                genreIds = new ArrayList<>();
            }
            return genreIds;
        }

        @NonNull
        public String getBackdropPath() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(backdropPath);
        }

        public boolean getAdult() {
            return adult;
        }

        @NonNull
        public String getOverview() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(overview);
        }

        @NonNull
        public String getReleaseDate() {
            return ErrorHandlerUtils.checkIfStringNullReturnEmpty(releaseDate);
        }
    }
}
