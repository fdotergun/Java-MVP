package com.base.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.base.helper.SharedPrefHelper;

/**
 * Created by ferhat on 11/21/2017.
 */
@Module
public class AppModule {

    public Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Gson providesGson(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    }

    @Provides
    @Singleton
    public Application providesApplication(){
        return application;
    }

    @Provides
    @Singleton
    public SharedPrefHelper providesSharedPrefHelper(Gson gson){
        return new SharedPrefHelper(application.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE),gson);
    }
}
