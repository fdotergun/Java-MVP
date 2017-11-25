package com.base.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ferhat on 11/21/2017.
 */
@Module
public class RetrofitModule {
    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient client){
        return new Retrofit.Builder().baseUrl("https://api.imgur.com/3/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
    }
}
