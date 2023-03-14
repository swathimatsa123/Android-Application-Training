package com.example.retrofitexample

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class APIClient {
    fun getRetroFitClient():Retrofit {
        val gson = GsonBuilder().setLenient().create()
        var retrofit = Retrofit.Builder()
            .baseUrl("https://www.breakingbadapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }

}