package com.test.module.discovery.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.module.discovery.R
import com.test.module.discovery.network.Total


/**
 *作者：sleepingfishboy
 *时间：2023/7/20

 */
class TotalAdapter : RecyclerView.Adapter<TotalAdapter.ViewHolder>() {
    private val itemList: MutableList<Total.Item> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundImage: ImageView = itemView.findViewById(R.id.backgroundImage)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
    }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

      override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        Glide.with(holder.itemView)
            .load(item.data.cover.feed)
            .into(holder.backgroundImage)

        holder.titleText.text = item.data.title
    }

      override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTotalData(totalItems: List<Total.Item>) {
        itemList.clear()
        itemList.addAll(totalItems)
        notifyDataSetChanged()

    }

}