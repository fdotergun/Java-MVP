package com.base;

import android.app.Application;

import com.base.di.component.AppComponent;
import com.base.di.component.DaggerAppComponent;
import com.base.di.module.AppModule;


public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Initialize app based constants here.
        initDagger();

    }

    private void initDagger(){
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

}
