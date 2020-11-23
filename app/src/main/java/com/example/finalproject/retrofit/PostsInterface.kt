package com.example.finalproject.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostsInterface {
    @GET("/api/posts")
    fun getAllPosts(): Call<List<RecyclerviewData>>
}