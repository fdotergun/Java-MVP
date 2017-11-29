package com.ferhatergun.javamvp.home;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import com.base.BaseActivity;
import com.base.helper.SharedPrefHelper;
import com.base.javamvp.R;
import com.ferhatergun.javamvp.home.di.DaggerHomeActivityComponent;
import com.ferhatergun.javamvp.home.di.HomeActivityModule;
import com.ferhatergun.javamvp.home.mvp.HomePresenter;
import com.ferhatergun.javamvp.home.mvp.HomeView;

/**
 * Created by ferhat on 11/21/2017.
 */

public class HomeActivity extends BaseActivity implements HomeView {

    /**
     * Injection : Field Injection
     */
    @Inject
    public HomePresenter homePresenter;

    @Inject
    public SharedPrefHelper sharedPrefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calling the method
        homePresenter.rxJavaSampleMethod();
    }

    @Override
    protected void onActivityInject() {
        DaggerHomeActivityComponent.builder().appComponent(getAppComponent())
                .homeActivityModule(new HomeActivityModule(this))
                .build()
                .inject(this);

        homePresenter.setHomeView(this);
    }

    /**
     * Activities only deals with UI and rest of the code
     * executed in Presenter.
     * @param message
     */
    @Override
    public void setToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
