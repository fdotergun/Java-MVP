package com.base.di.module;

import android.app.Application;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import com.base.service.ConnectionUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by ferhat on 11/21/2017.
 */

@Module
public class OkHttpModule {

    private OkHttpClient.Builder getBaseBuilder(Cache cache){
        return new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120,TimeUnit.SECONDS)
                .writeTimeout(120,TimeUnit.SECONDS);
    }

    private class CachingControlInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder requestBuilder = chain.request().newBuilder();
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxStale(7,TimeUnit.DAYS)
                    .maxAge(7,TimeUnit.DAYS)
                    .build();

            requestBuilder.cacheControl(cacheControl);
            requestBuilder.header("Content-Type","application/json");
            Request request = requestBuilder.build();

            Response response = chain.proceed(request);
            String headerValue;
            if (ConnectionUtil.isNetworkConnected())
                headerValue = "public, max-age=60";
            else
                headerValue = "public, only-if-cached, max-stale=604800";
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control",headerValue)
                    .build();
        }
    }

    @Provides
    @Singleton
    public Cache providesOkHttpCache(Application application){
        return new Cache(application.getCacheDir(),10 * 1024 * 1024);
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor providesLogginInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttp(Cache cache,HttpLoggingInterceptor httpLoggingInterceptor){
       return getBaseBuilder(cache).addNetworkInterceptor(new CachingControlInterceptor()).addInterceptor(httpLoggingInterceptor).build();
    }

}
