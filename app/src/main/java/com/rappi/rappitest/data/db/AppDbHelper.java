
package com.rappi.rappitest.data.db;


import com.rappi.rappitest.data.db.model.DaoMaster;
import com.rappi.rappitest.data.db.model.DaoSession;
import com.rappi.rappitest.data.db.model.Movie;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertMovie(final Movie movie) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getMovieDao().insert(movie);
            }
        });
    }

    @Override
    public Observable<List<Movie>> getAllMovies() {
        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return mDaoSession.getMovieDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> deleteMovies() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getMovieDao().deleteAll();
                return true;
            }
        });
    }
}
