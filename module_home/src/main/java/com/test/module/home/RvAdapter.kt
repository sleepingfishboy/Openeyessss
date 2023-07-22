package com.test.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide


class RvAdapter(private val dataList: MutableList<RecommendResponse.Item>):RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.rm_image_view)
        val tvTitle:TextView=itemView.findViewById(R.id.rm_title)
        val tvAuthor:TextView=itemView.findViewById(R.id.rm_tag)
    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=dataList[position]

        if (item != null && item.data.cover != null) {
            Glide.with(holder.itemView).load(item.data.cover.detail).into(holder.imageView)
            holder.tvTitle.text=item.data.title
            holder.tvAuthor.text=item.data.author.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_recommend,parent,false)
        val viewHolder=ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener {
            val position=viewHolder.adapterPosition
            val item=dataList[position]
            ARouter.getInstance().build("/player/activity","player").withString("url",item.data.playUrl).withString("title",item.data.title).navigation()
        }
        return viewHolder
    }

}