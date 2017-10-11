

package com.rappi.rappitest.ui.login;


import android.support.annotation.StringRes;

import com.rappi.rappitest.ui.base.MvpView;


public interface LoginMvpView extends MvpView {

    void openMainActivity();

    void onInputError(int pos, @StringRes int message);
}
