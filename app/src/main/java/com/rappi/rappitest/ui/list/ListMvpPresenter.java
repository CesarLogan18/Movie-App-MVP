

package com.rappi.rappitest.ui.list;


import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.ui.base.MvpPresenter;

@PerActivity
public interface ListMvpPresenter<V extends ListMvpView> extends MvpPresenter<V> {

    void onLoadMoreItems(int page, int position);

    void filterList(int position, String filter);

    void onModeChange(int position, boolean offLine);

    void onTabChange(int position, boolean offLine);

    void onMovieSelected(Movie movie);

}
