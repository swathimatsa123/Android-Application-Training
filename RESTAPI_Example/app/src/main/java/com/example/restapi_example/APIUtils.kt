package com.example.restapi_example


object ApiUtils {
    const val BASE_URL = "https://dummy.restapiexample.com/api/"
    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)?.create(APIService::class.java)!!
}