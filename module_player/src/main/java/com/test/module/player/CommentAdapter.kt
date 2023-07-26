package com.test.module.player

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 *作者：sleepingfishboy
 *时间：2023/7/25

 */

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    private val itemList: MutableList<CommentBean.Item> = mutableListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImage: ImageView = itemView.findViewById(R.id.iv_avatar)
        val titleText: TextView = itemView.findViewById(R.id.tv_comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comments, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        if (item.data.user != null) {
            Glide.with(holder.itemView)
                .load(item.data.user.avatar)
                .into(holder.avatarImage)
        }

        if (item.data != null) {
            holder.titleText.text = item.data.user?.nickname + "•" + item.data.message
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setCommentData(commentItems: List<CommentBean.Item>) {
        itemList.clear()
        for (item in commentItems) {
            if (item.data.user != null && item.data.user.nickname != null) {
                itemList.add(item)
            }
        }
        notifyDataSetChanged()
    }
}