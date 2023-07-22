package com.test.module.discovery.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.test.module.discovery.R
import com.test.module.discovery.network.Weekly

/**
 *作者：sleepingfishboy
 *时间：2023/7/20

 */
class WeekAdapter : RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    private val itemList: MutableList<Weekly.Item> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundImage: ImageView = itemView.findViewById(R.id.backgroundImage)
        val titleText: TextView = itemView.findViewById(R.id.titleText)

        init {
            itemView.setOnClickListener {
                // 处理item点击事件
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = itemList[position]
                    ARouter.getInstance().build("/player/activity")
                        .withString("url", item.data.playUrl)
                        .withString("description", item.data.description)
                        .withString("title", item.data.title)
                        .withString("id", item.data.id.toString())
                        .navigation()

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
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
    fun setWeeklyData(weeklyItems: List<Weekly.Item>) {
        itemList.clear()
        itemList.addAll(weeklyItems)
        notifyDataSetChanged()
    }

}