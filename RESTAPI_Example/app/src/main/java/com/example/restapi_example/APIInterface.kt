package com.example.restapi_example

import retrofit2.Call
import retrofit2.http.*


interface APIService {

    @POST("v1/create/")
    fun saveData(
       @Body employee: Employee
    ): Call<Employee>?
}