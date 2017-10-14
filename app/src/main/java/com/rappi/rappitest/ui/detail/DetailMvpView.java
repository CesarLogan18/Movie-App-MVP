package com.rappi.rappitest.ui.detail;

import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.ui.base.MvpView;

public interface DetailMvpView extends MvpView {

    void updateUI(Movie movie);
}
