package com.example.jsonplaceholder

interface BaseView<T> {
    fun setViewModel(viewModel: T)
}