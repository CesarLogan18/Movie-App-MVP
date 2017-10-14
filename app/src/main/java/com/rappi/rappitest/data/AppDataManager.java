package com.rappi.rappitest.data;

import com.rappi.rappitest.data.db.DbHelper;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.data.network.ApiHelper;
import com.rappi.rappitest.data.network.model.MovieListResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private final DbHelper mDbHelper;
    private final ApiHelper mApiHelper;
    private Movie movie;

    @Inject
    public AppDataManager(DbHelper dbHelper,
                          ApiHelper apiHelper) {

        mDbHelper = dbHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<Long> insertMovie(Movie movie) {
        return mDbHelper.insertMovie(movie);
    }


    @Override
    public Observable<List<Movie>> getMoviesByCategory(int category) {
        return mDbHelper.getMoviesByCategory(category);
    }

    @Override
    public Observable<Boolean> deleteMovies(int category) {
        return mDbHelper.deleteMovies(category);
    }

    @Override
    public Observable<MovieListResponse> doMovieListApiCall(int page, int category) {
        return mApiHelper.doMovieListApiCall(page, category);
    }

    @Override
    public void setCurrentMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Movie getCurrentMovie() {
        return movie;
    }
}
