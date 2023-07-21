package com.test.module.square

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SquareAdapter(private val dataList: MutableList<Item>): RecyclerView.Adapter<SquareAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.square_image)
        val tvTitle:TextView=itemView.findViewById(R.id.square_title)
        val tvAuthor:TextView=itemView.findViewById(R.id.square_author)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=dataList[position]

        if (item != null && item.data.content != null && item.data.content.data.cover!=null) {
            Glide.with(holder.itemView).load(item.data.content.data.cover.detail).into(holder.imageView)
            holder.tvTitle.text=item.data.content.data.description
            holder.tvAuthor.text=item.data.content.data.owner.nickname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(itemView)
    }
}