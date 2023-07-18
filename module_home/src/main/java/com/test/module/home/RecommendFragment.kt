package com.test.module.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class RecommendFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.rv_recommend)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=RvAdapter(listOf("a","b"))
    }

}