

package com.rappi.rappitest.di.component;

import android.app.Application;
import android.content.Context;

import com.rappi.rappitest.MvpApp;
import com.rappi.rappitest.data.DataManager;
import com.rappi.rappitest.di.ApplicationContext;
import com.rappi.rappitest.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}