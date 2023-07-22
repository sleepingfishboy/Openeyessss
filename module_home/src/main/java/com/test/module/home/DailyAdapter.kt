package com.test.module.home

import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions


class DailyAdapter(private val dataList: MutableList<Item>) :
    RecyclerView.Adapter<DailyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.card_image)
        val tvTitle: TextView = itemView.findViewById(R.id.card_title)
        val tvAuthor: TextView = itemView.findViewById(R.id.card_author)
        val icon: ImageView = itemView.findViewById(R.id.card_icon)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        if (item != null) {
            Glide.with(holder.itemView).load(item.data.content.data.cover.detail)
                .into(holder.imageView)
            Glide.with(holder.itemView).load(item.data.content.data.author.icon).apply(
                RequestOptions().transform(CircleCrop())
            ).into(holder.icon)
            holder.tvTitle.text = item.data.content.data.title
            holder.tvAuthor.text = item.data.content.data.author.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        val viewHolder=ViewHolder(itemView)
        viewHolder.imageView.setOnClickListener{
            val position=viewHolder.adapterPosition
            val item=dataList[position]
            ARouter.getInstance().build("/player/activity","player").withString("url",item.data.content.data.playUrl).withString("title",item.data.content.data.title).navigation()
        }
        return viewHolder
    }
}