package com.example.finalproject.retrofit

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    var retrofit: Retrofit? = null
    fun getClient(context: Context): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://academy-training.appssquare.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}