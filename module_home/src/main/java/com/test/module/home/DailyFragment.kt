package com.test.module.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.concurrent.thread


class DailyFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeRefreshLayout=view.findViewById(R.id.swipeRefresh)
        recyclerView=view.findViewById(R.id.rv_daily)
        val layoutManager: RecyclerView.LayoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=DailyAdapter(listOf("a","b","c","d"))
        swipeRefreshLayout.setColorSchemeResources(R.color.black)
        swipeRefreshLayout.setOnRefreshListener {
            refresh(DailyAdapter(listOf("a","b","c","d")))
        }
    }

    private fun refresh(dailyAdapter: DailyAdapter){
        thread {
            Thread.sleep(1000)
            run{
                dailyAdapter.notifyDataSetChanged()
                swipeRefreshLayout.isRefreshing=false
            }
        }
    }
}