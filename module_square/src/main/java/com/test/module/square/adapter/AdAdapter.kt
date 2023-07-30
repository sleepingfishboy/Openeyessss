package com.test.module.square.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.test.module.square.data.Advertisement
import com.test.module.square.R

class AdAdapter(private val dataList: MutableList<Advertisement.Item>) :
    RecyclerView.Adapter<AdAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val tvTitle: TextView = itemView.findViewById(R.id.title)
        val tvAuthor: TextView = itemView.findViewById(R.id.tag)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        if (item != null && item.data.content.data.cover != null) {
            Glide.with(holder.itemView).load(item.data.content.data.cover.detail)
                .into(holder.imageView)
            holder.tvTitle.text = item.data.content.data.title
            holder.tvAuthor.text = item.data.content.data.author.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val item = dataList[position]

            ARouter.getInstance().build("/player/activity")
                .withString("url", item.data.content.data.playUrl)
                .withString("description", item.data.content.data.description)
                .withString("title", item.data.content.data.title)
                .withString("id", item.data.content.data.id.toString())
                .withString("webUrl", item.data.content.data.webUrl.raw)
                .navigation()
        }
        return viewHolder
    }
}