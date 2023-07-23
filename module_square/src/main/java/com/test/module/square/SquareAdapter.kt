package com.test.module.square

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder

class SquareAdapter(private val dataList: List<Int>): RecyclerView.Adapter<SquareAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.carousel_image_view1)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=dataList[position]

        Glide.with(holder.itemView).load(item).into(holder.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.item_carousel,parent,false)
        return ViewHolder(itemView)
    }
}