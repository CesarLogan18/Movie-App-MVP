package com.rappi.rappitest.ui.list;

import com.androidnetworking.error.ANError;
import com.rappi.rappitest.data.DataManager;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.data.network.model.MovieListResponse;
import com.rappi.rappitest.ui.base.BasePresenter;
import com.rappi.rappitest.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class ListPresenter<V extends ListMvpView> extends BasePresenter<V> implements ListMvpPresenter<V> {

    @Inject
    public ListPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void onLoadMoreItems(int page) {
        if (page >= 0) {
            loadMoviesFromApi(page);
        } else
            loadMoviesFromDataBase();

    }

    private void loadMoviesFromDataBase() {
        getCompositeDisposable().add(getDataManager()
                .getAllMovies()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Movie>>() {
                    @Override
                    public void accept(List<Movie> movies) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().refreshList(movies);


                    }
                }));
    }

    private void loadMoviesFromApi(int page) {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .doMovieListApiCall(page)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<MovieListResponse>() {
                    @Override
                    public void accept(MovieListResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        List<Movie> movies = convertApiToList(response);
                        getMvpView().refreshList(movies);
                        saveInDb(movies);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }

    @Override
    public void filterList(String filter) {

    }

    private List<Movie> convertApiToList(MovieListResponse response) {

        List<Movie> list = new ArrayList<>();
        for (MovieListResponse.MovieResponse movieResponse : response.getResults()) {
            final Movie movie = new Movie();
            movie.setLanguage(movieResponse.getOriginalLanguage());
            movie.setName(movieResponse.getTitle());
            movie.setVoteAvg(movieResponse.getVoteAverage());
            movie.setImageUrl(movieResponse.getPosterPath());
            movie.setDate(movieResponse.getReleaseDate());
            list.add(movie);
        }

        return list;
    }

    private void saveInDb(List<Movie> movies) {
        for (Movie movie : movies) {
            getCompositeDisposable().add(getDataManager().insertMovie(movie)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long id) throws Exception {
                            if (!isViewAttached()) {
                                return;
                            }
                        }
                    }));
        }
    }

}

