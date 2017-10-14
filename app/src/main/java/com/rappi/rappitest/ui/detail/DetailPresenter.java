package com.rappi.rappitest.ui.detail;

import com.rappi.rappitest.data.DataManager;
import com.rappi.rappitest.ui.base.BasePresenter;
import com.rappi.rappitest.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public class DetailPresenter<V extends DetailMvpView> extends BasePresenter<V> implements DetailMvpPresenter<V> {


    @Inject
    public DetailPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadCurrentMovie() {
        if (getDataManager().getCurrentMovie() != null)
            getMvpView().updateUI(getDataManager().getCurrentMovie());
    }
}
