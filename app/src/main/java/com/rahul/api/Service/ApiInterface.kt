package com.rahul.api.Service

import com.rahul.api.model.Model
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/users/2")
    fun getData(): Observable<Model>

}