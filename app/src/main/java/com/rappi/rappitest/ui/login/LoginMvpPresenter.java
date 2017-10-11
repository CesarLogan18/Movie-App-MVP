

package com.rappi.rappitest.ui.login;


import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.ui.base.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);


}
