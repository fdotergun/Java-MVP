package com.ferhatergun.javamvp.home.mvp;

import com.ferhatergun.javamvp.home.model.SampleModel;
import com.google.gson.Gson;

import javax.inject.Inject;

import com.base.Endpoints;
import com.base.helper.SharedPrefHelper;
import com.base.mvp.BasePresenter;

import java.lang.ref.WeakReference;

/**
 * Created by ferhat on 11/25/2017.
 */

public class HomePresenter extends BasePresenter{

    private Endpoints api;
    private SharedPrefHelper sharedPrefHelper;
    private Gson gson;
    private HomeView homeView;

    /**
     * Boilerplate Code : Constructor
     * You can create new methods and execute here
     * And your Main Activity deals with only UI
     *
     * Inject Type : Constructor Injection
     */

    @Inject
    public HomePresenter(Endpoints api, SharedPrefHelper sharedPrefHelper, Gson gson){
        this.api = api;
        this.sharedPrefHelper = sharedPrefHelper;
        this.gson = gson;
    }
    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }

    /**
     * Sample method, receives string from main activity
     * and overrides setToast method at MainActivity
     */
    public void showToastWithObject(){
        if (sharedPrefHelper.getSampleObject() == null){
            sharedPrefHelper.setSampleObject(new SampleModel("Ferhat ERGUN","h.f.ergun@gmail.com","1"));
        }
        homeView.setToast(sharedPrefHelper.getSampleObject().getEmail());
    }
}
