package com.example.jsonplaceholder.posts

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PostsViewModel(val postsView: PostsContract.View): PostsContract.ViewModel {

    lateinit var retrofit: Retrofit
    init {
        postsView.setViewModel(this)
    }

    interface PostsAPI {
        @GET("/posts")
        fun getAPI() : Call<List<PostsModel>>
    }

    override fun setup() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun callAPI() {
        retrofit.create(PostsAPI::class.java)
            .getAPI()
            .enqueue(object : Callback<List<PostsModel>> {
                override fun onResponse(call: Call<List<PostsModel>>, response: Response<List<PostsModel>>) {
                    postsView.onSuccessAPI(response.body()!!)
                }

                override fun onFailure(call: Call<List<PostsModel>>, t: Throwable) {
                    postsView.onFailureAPI(t)
                }
            })
    }
}