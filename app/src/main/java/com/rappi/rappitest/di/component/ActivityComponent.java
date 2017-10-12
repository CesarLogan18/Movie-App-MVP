
package com.rappi.rappitest.di.component;


import com.rappi.rappitest.ui.list.ListActivity;
import com.rappi.rappitest.di.PerActivity;
import com.rappi.rappitest.di.module.ActivityModule;

import dagger.Component;



@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ListActivity activity);

}
