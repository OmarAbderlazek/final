package com.example.finalproject.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginClient {
    var retrofitLogin: Retrofit? = null
    val gson = GsonBuilder().setLenient().create()

    fun getRetrofitInstance() {
        if (retrofitLogin == null) {
            retrofitLogin = Retrofit.Builder()
                .baseUrl("https://academy-training.appssquare.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        }
    }
}