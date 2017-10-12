

package com.rappi.rappitest.ui.list;


import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.ui.base.MvpPresenter;

@PerActivity
public interface ListMvpPresenter<V extends ListMvpView> extends MvpPresenter<V> {

    void onLoadMoreItems(int page);

    void filterList(String filter);

}
