package com.evaluation.network;

import com.evaluation.model.UserList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("api/")
    Single<UserList> getUserList(@Query("results") int results);

}


