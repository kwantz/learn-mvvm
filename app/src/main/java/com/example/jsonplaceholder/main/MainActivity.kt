package com.example.jsonplaceholder.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.jsonplaceholder.R
import com.example.jsonplaceholder.posts.PostsActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mainViewModel: MainContract.ViewModel
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        MainViewModel(this)
    }

    override fun setViewModel(viewModel: MainContract.ViewModel) {
        mainViewModel = viewModel
        mainViewModel.setup()
    }

    override fun setupButton() {
        button.setOnClickListener{
            startActivity(Intent(baseContext, PostsActivity::class.java))
        }
    }
}
