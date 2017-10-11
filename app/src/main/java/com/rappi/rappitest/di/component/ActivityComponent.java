
package com.rappi.rappitest.di.component;


import com.rappi.rappitest.MainActivity;
import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.di.module.ActivityModule;

import dagger.Component;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}
