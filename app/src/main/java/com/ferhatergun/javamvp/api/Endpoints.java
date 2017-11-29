package com.ferhatergun.javamvp.api;

import com.ferhatergun.javamvp.home.model.News;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ferhat on 11/25/2017.
 */

public interface Endpoints {
    @GET("59cc13f726000062106b773d")
    Observable<List<News>> search();
}
