package com.example.finalproject.retrofit

import com.google.gson.annotations.SerializedName

data class RecyclerviewData(
    @SerializedName("title")
    val title: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("body")
    val body: String,
    @SerializedName("author_id")
    val author_id: Int,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("updated_at")
    val updated_at: String
)