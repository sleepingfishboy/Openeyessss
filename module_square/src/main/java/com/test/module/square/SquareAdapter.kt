package com.test.module.square

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
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
        if (item!=null){
            Glide.with(holder.itemView).load(item).into(holder.imageView)}
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.item_carousel,parent,false)
        val viewHolder=ViewHolder(itemView)
        viewHolder.imageView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val item=dataList[position]
            val intent=Intent(itemView.context,TagActivity::class.java)
            intent.putExtra("position",position)
            intent.putExtra("imageID",item)
            itemView.context.startActivity(intent)
        }
        return viewHolder
    }
}