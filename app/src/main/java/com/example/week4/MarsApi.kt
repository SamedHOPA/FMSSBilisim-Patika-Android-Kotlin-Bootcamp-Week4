package com.example.week4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Api BASSE_URL'si alındı ve retrofit build edildi.
 */

object MarsApi {

    private var BASE_URL = "https://mars.udacity.com/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}