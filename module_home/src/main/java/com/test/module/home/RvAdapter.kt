package com.test.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide


class RvAdapter :
    PagingDataAdapter<AllRec.Item,RvAdapter.ViewHolder>(COMPARATOR) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<AllRec.Item>() {
            override fun areItemsTheSame(oldItem: AllRec.Item, newItem: AllRec.Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: AllRec.Item, newItem: AllRec.Item): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.rm_image_view)
        val tvTitle: TextView = itemView.findViewById(R.id.rm_title)
        val tvAuthor: TextView = itemView.findViewById(R.id.rm_tag)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item != null && item.data.cover != null&&item.data.author!=null) {
            Glide.with(holder.itemView).load(item.data.cover.detail).into(holder.imageView)
            holder.tvTitle.text = item.data.title
            holder.tvAuthor.text = item.data.author.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recommend, parent, false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val item = getItem(position)

            if (item != null&&item.data.author!=null&&item.data.title!=null) {
                ARouter.getInstance().build("/player/activity")
                    .withString("url", item.data.playUrl)
                    .withString("description",item.data.description)
                    .withString("title", item.data.title)
                    .withString("id",item.data.id.toString())
                    .withString("webUrl",item.data.webUrl.raw)
                    .navigation()
            }
        }
        return viewHolder
    }

}