package com.test.module.square.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.module.square.R
import com.test.module.square.activity.TagActivity

class SquareAdapter(private val dataList: List<String>) :
    RecyclerView.Adapter<SquareAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.carousel_image_view1)
        val textView: TextView = itemView.findViewById(R.id.carousel_text_view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        if (item != null) {
            Glide.with(holder.itemView).load(item).into(holder.imageView)
        }
        holder.textView.text = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.imageView.setOnClickListener {
            //跳转到点击对应的分类页面中
            val position = viewHolder.adapterPosition
            val intent = Intent(itemView.context, TagActivity::class.java)
            intent.putExtra("position", position)
            itemView.context.startActivity(intent)
        }
        return viewHolder
    }
}