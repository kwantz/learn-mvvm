package com.example.jsonplaceholder.main

import com.example.jsonplaceholder.BaseView
import com.example.jsonplaceholder.BaseViewModel

interface MainContract {
    interface View: BaseView<ViewModel> {
        fun setupButton()
    }

    interface ViewModel: BaseViewModel {

    }
}