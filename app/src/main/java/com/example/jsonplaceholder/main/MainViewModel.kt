package com.example.jsonplaceholder.main

import android.util.Log

class MainViewModel(val mainView: MainContract.View): MainContract.ViewModel {

    init {
        mainView.setViewModel(this)
    }

    override fun setup() {
        // code...
        Log.i("MainViewModel", "Setup Success...")
        mainView.setupButton()
    }
}