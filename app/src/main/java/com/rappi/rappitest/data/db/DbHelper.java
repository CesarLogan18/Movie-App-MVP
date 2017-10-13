

package com.rappi.rappitest.data.db;

import com.rappi.rappitest.data.db.model.Movie;

import java.util.List;

import io.reactivex.Observable;


public interface DbHelper {

    Observable<Long> insertMovie(final Movie movie);

    Observable<List<Movie>> getAllMovies();

    Observable<Boolean> deleteMovies();

}
