package com.example.jsonplaceholder.posts

import com.google.gson.annotations.SerializedName

data class PostsModel (
    @SerializedName("id") var id: Int,
    @SerializedName("userId") var userId: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String
)
