package com.example.jsonplaceholder.posts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.R

class PostsActivity : AppCompatActivity(), PostsContract.View {

    lateinit var postsViewModel: PostsContract.ViewModel
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        title = "Posts"
        recyclerView = findViewById(R.id.recycle_view)
        PostsViewModel(this)
    }

    override fun setViewModel(viewModel: PostsContract.ViewModel) {
        postsViewModel = viewModel
        postsViewModel.setup()
    }

    override fun onResume() {
        super.onResume()
        postsViewModel.callAPI()
    }

    override fun onSuccessAPI(model: List<PostsModel>) {
        Log.i("PostsActivity", "onSuccessAPI")

        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = PostsAdapter(model)
        recyclerView.layoutManager =LinearLayoutManager(baseContext)
    }

    override fun onFailureAPI(t: Throwable) {
        Log.i("PostsActivity", "onFailureAPI: " + t.toString())
    }
}
