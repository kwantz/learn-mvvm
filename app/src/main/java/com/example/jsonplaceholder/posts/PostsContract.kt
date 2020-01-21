package com.example.jsonplaceholder.posts

import com.example.jsonplaceholder.BaseView
import com.example.jsonplaceholder.BaseViewModel

interface PostsContract {
    interface View: BaseView<ViewModel> {
        fun onSuccessAPI(model: List<PostsModel>)
        fun onFailureAPI(t: Throwable)
    }

    interface ViewModel: BaseViewModel {
        fun callAPI()
    }
}