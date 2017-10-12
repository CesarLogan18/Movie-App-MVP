
package com.rappi.rappitest.di.module;

import android.app.Application;
import android.content.Context;

import com.rappi.rappitest.BuildConfig;
import com.rappi.rappitest.R;
import com.rappi.rappitest.data.AppDataManager;
import com.rappi.rappitest.data.DataManager;
import com.rappi.rappitest.data.db.AppDbHelper;
import com.rappi.rappitest.data.db.DbHelper;
import com.rappi.rappitest.data.network.ApiHelper;
import com.rappi.rappitest.data.network.AppApiHelper;
import com.rappi.rappitest.di.ApiInfo;
import com.rappi.rappitest.di.ApplicationContext;
import com.rappi.rappitest.di.DatabaseInfo;
import com.rappi.rappitest.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;



@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
