package com.rappi.rappitest.ui.detail;


import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.ui.base.MvpPresenter;

@PerActivity
public interface DetailMvpPresenter<V extends DetailMvpView> extends MvpPresenter<V> {

    void loadCurrentMovie();
}
