package com.test.module.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class RecommendFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: RvAdapter

    val viewModel by lazy { ViewModelProvider(this).get(RecommendViewModel::class.java) }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.recommendLiveData.observe(this,Observer{result->
            val recommend=result.get(0)
            viewModel.recommendLiveData.value=recommend.toString()
        })
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
        recyclerView= requireView().findViewById(R.id.rv_recommend)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
        rvAdapter=RvAdapter(this,viewModel.recommendList)
        recyclerView.adapter=rvAdapter
    }
}