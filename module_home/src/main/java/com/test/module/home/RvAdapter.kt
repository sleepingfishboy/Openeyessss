package com.test.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


class RvAdapter(private val fragment: Fragment, private val dataList: List<RecommendResponse.Item>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){
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
        holder.tvTitle.text=item.data.title
        holder.tvAuthor.text=item.data.author.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_recommend,parent,false)
        return ViewHolder(itemView)
    }


}