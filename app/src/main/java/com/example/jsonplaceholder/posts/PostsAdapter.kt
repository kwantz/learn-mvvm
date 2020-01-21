package com.example.jsonplaceholder.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.R

class PostsAdapter(private val model: List<PostsModel>): RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private lateinit var view: View

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textTitle: TextView = v.findViewById(R.id.text_title)
        val textBody: TextView = v.findViewById(R.id.text_body)
        val textUser: TextView = v.findViewById(R.id.text_user_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_posts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = model.get(position)

        holder.textTitle.text = post.title
        holder.textBody.text = post.body
        holder.textUser.text = post.userId.toString()
    }

    override fun getItemCount(): Int = model.size
}