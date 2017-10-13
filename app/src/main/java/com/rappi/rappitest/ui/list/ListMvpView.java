

package com.rappi.rappitest.ui.list;


import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.ui.base.MvpView;

import java.util.List;


public interface ListMvpView extends MvpView {

    void openDetailActivity(Movie movie);

    void refreshList(List<Movie> items);


    void showLabelNoItem();

    void hideLabelNoItem();

    void showSearchBar();

    void hideSearchBar();

    void resetAdapter();


}
