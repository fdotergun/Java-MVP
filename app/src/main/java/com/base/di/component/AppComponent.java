package com.base.di.component;

import android.app.Application;
import com.google.gson.Gson;
import javax.inject.Singleton;
import dagger.Component;
import com.base.Endpoints;
import com.base.di.module.ApiModule;
import com.base.di.module.AppModule;
import com.base.di.module.OkHttpModule;
import com.base.di.module.RetrofitModule;
import com.base.helper.SharedPrefHelper;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;


@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class, OkHttpModule.class, ApiModule.class})
public interface AppComponent {
    Endpoints endpoints();
    Application application();
    Gson gson();
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPrefHelper sharedPref();

}
