package com.example.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class ViewPagerAdapter(fragment: Fragment):RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    private val fragments=ArrayList<Fragment>()

    init{
        fragments.add(DailyFragment())
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fragment=fragments[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_recommend,parent,false)
        return ViewHolder(view)
    }

}