package com.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import com.base.di.component.AppComponent;
import com.base.event.DefaultEvent;
import com.base.javamvp.R;
import com.base.mvp.BasePresenter;
import com.base.mvp.BaseView;

abstract public class BaseActivity extends AppCompatActivity implements BaseView {

    public BasePresenter presenter;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        onActivityInject();
    }

    protected abstract void onActivityInject();

    public static AppComponent getAppComponent(){
        return App.appComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void subscribeDefault(DefaultEvent defaultEvent){

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
