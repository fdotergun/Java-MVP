package com.ferhatergun.javamvp.home.di;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import com.base.Endpoints;
import com.base.di.ActivityScope;
import com.base.helper.SharedPrefHelper;
import com.ferhatergun.javamvp.home.mvp.HomePresenter;

/**
 * Created by ferhat on 11/25/2017.
 */


@Module
public class HomeActivityModule {

    private Activity activity;

    public HomeActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Context providesContext(){
        return activity;
    }

    @Provides
    @ActivityScope
    public HomePresenter providesHomePresenter(Endpoints api,SharedPrefHelper sharedPrefHelper,Gson gson){
        return new HomePresenter(api,sharedPrefHelper,gson);
    }
}
