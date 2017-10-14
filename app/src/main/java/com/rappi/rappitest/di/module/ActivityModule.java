package com.rappi.rappitest.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.rappi.rappitest.di.ActivityContext;
import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.ui.detail.DetailMvpPresenter;
import com.rappi.rappitest.ui.detail.DetailMvpView;
import com.rappi.rappitest.ui.detail.DetailPresenter;
import com.rappi.rappitest.ui.list.ListMvpPresenter;
import com.rappi.rappitest.ui.list.ListMvpView;
import com.rappi.rappitest.ui.list.ListPresenter;
import com.rappi.rappitest.utils.rx.AppSchedulerProvider;
import com.rappi.rappitest.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    ListMvpPresenter<ListMvpView> provideListPresenter(ListPresenter<ListMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailMvpPresenter<DetailMvpView> provideDetailPresenter(DetailPresenter<DetailMvpView> presenter) {
        return presenter;
    }
}
