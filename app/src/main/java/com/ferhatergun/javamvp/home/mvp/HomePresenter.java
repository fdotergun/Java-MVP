package com.ferhatergun.javamvp.home.mvp;

import android.util.Log;

import com.ferhatergun.javamvp.api.Endpoints;
import com.ferhatergun.javamvp.home.model.News;
import com.ferhatergun.javamvp.home.model.SampleModel;
import com.google.gson.Gson;

import javax.inject.Inject;

import com.base.helper.SharedPrefHelper;
import com.base.mvp.BasePresenter;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ferhat on 11/25/2017.
 */

public class HomePresenter extends BasePresenter{

    private Endpoints api;
    private SharedPrefHelper sharedPrefHelper;
    private Gson gson;
    private HomeView homeView;

    @Inject
    public CompositeDisposable compositeDisposable;
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

    public void rxJavaSampleMethod(){
        compositeDisposable.add(api.search()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<News>>() {
                    @Override
                    public void accept(List<News> news) throws Exception {
                        homeView.setToast(news.get(0).getTitle());
                        for (News list : news){
                            Log.v("Haber " , list.getTitle().toString());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        homeView.setToast(throwable.getMessage());
                        Log.v(throwable.getMessage(),throwable.getLocalizedMessage());
                    }
                }));
    }
}
