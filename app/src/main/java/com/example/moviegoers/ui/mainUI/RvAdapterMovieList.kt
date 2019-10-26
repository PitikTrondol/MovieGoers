package com.example.moviegoers.ui.mainUI

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.moviegoers.R
import com.example.moviegoers.model.ResultsItem

class RvAdapterMovieList(private val context : Context, private val listener: OnItemClickListener)
    : RecyclerView.Adapter<RvAdapterMovieList.ViewHolder>() {

    private var selectedItem: ResultsItem? = null
    var data : ArrayList<ResultsItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.desc.text = data[position].overview
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
            selectedItem = data[position]
            notifyDataSetChanged()
        }

        if(data[position] == selectedItem){
            val backgroundColor = ContextCompat.getColor(context, R.color.colorPrimaryLight)
            holder.itemView.setBackgroundColor(backgroundColor)
            holder.title.setTextColor(Color.WHITE)
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE)
            holder.title.setTextColor(Color.BLACK)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Int)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var title: TextView = v.findViewById<View>(R.id.tv_title) as TextView
        var desc: TextView = v.findViewById<View>(R.id.tv_desc) as TextView
    }
}