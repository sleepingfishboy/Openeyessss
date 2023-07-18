package com.test.module.home

import android.provider.ContactsContract.Contacts.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.card.MaterialCardView

class RvAdapter(private val dataList: List<String>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){
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

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_recommend,parent,false)
        return ViewHolder(itemView)
    }


}