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

class CommentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList: MutableList<CommentBean.Item> = mutableListOf()

    private val VIEW_TYPE_COMMENT = 0
    private val VIEW_TYPE_EMPTY = 1

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.tv_comment)
    }

    inner class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emptyText: TextView = itemView.findViewById(R.id.tv_empty_comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_COMMENT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_comments, parent, false)
                CommentViewHolder(view)
            }
            VIEW_TYPE_EMPTY -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_comments, parent, false)
                EmptyViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CommentViewHolder -> {
                val item = itemList[position]
                if (item.data != null) {
                    holder.titleText.text =
                        item.data.user?.nickname + " 评论：" + item.data.message
                }
            }
            is EmptyViewHolder -> {
                holder.emptyText.text = "还没有评论哦"+"\n"+" "
            }
        }
    }

    override fun getItemCount(): Int {
        return if (itemList.isEmpty()) 1 else itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList.isEmpty()) VIEW_TYPE_EMPTY else VIEW_TYPE_COMMENT
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