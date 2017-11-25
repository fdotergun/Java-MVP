package com.ferhatergun.javamvp.home.di;

import dagger.Component;
import com.base.di.ActivityScope;
import com.base.di.component.AppComponent;
import com.ferhatergun.javamvp.home.HomeActivity;

/**
 * Created by ferhat on 11/25/2017.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class} , modules = {HomeActivityModule.class})
public interface HomeActivityComponent {
    void inject(HomeActivity homeActivity);
}
