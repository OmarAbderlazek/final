package com.example.finalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.retrofit.RecyclerviewData
import kotlinx.android.synthetic.main.item.view.*

class Adapter(val list: List<RecyclerviewData>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
        val id: TextView = itemView.idd
        val body: TextView = itemView.body
        val author_id: TextView = itemView.author_id
        val created_at: TextView = itemView.created_at
        val updated_at:TextView = itemView.updated_at

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.title.text = currentItem.title.toString()
        holder.id.text = currentItem.id.toString()
        holder.body.text = currentItem.body
        holder.author_id.text = currentItem.author_id.toString()
        holder.created_at.text = currentItem.created_at
        holder.updated_at.text = currentItem.updated_at

    }

    override fun getItemCount() = list.size
}