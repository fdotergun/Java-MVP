package com.base.di.module;

import com.ferhatergun.javamvp.api.Endpoints;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ferhat on 11/21/2017.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    public Endpoints providesEndpoints(Retrofit retrofit){
        return retrofit.create(Endpoints.class);
    }
}
