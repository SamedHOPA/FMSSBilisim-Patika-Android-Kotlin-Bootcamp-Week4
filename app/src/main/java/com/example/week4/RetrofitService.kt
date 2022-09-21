package com.example.week4


import retrofit2.Call
import retrofit2.http.GET

/**
 * retrofit BASE_URL'si için kullanmak istediğimiz key'i tanımladık.
 *
 */

interface RetrofitService {
    @GET("realestate")
    fun getMars(): Call<List<MarsModel>>
}