package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface APIINTERFACE {
    @GET("deaths")
    fun getDeaths(): Call<List<DataModel>>
}