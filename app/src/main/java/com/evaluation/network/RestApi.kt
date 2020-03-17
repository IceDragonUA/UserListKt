package com.evaluation.network

import com.evaluation.model.UserList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("api/")
    fun getUserList(@Query("results") results: Int): Observable<UserList>

}