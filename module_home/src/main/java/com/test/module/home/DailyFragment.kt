package com.test.module.home

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.concurrent.thread


class DailyFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var dailyAdapter: DailyAdapter
    private lateinit var liveData: MutableLiveData<MutableList<Item>>
    private val networkChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // 处理网络变化情况
            val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            val isConnected = networkInfo != null && networkInfo.isConnected

            if (isConnected) {
                // 网络已连接，执行相应操作
                viewModel.setDisposable(swipeRefreshLayout)
            } else {
                // 网络已断开，显示错误信息
                Toast.makeText(context,"网络连接已断开",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val viewModel by lazy { ViewModelProvider(this)[DailyViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liveData = viewModel.getData() as MutableLiveData<MutableList<Item>>
        liveData.observe(this, Observer { dailyList ->
            dailyAdapter = DailyAdapter(dailyList)
            recyclerView.adapter = dailyAdapter

            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setDisposable(swipeRefreshLayout)
            }
        })
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
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh_daily)
        recyclerView = view.findViewById(R.id.rv_daily)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        swipeRefreshLayout.setColorSchemeResources(R.color.pink)
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        requireActivity().registerReceiver(networkChangeReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        requireActivity().unregisterReceiver(networkChangeReceiver)
    }

    private fun refresh(dailyAdapter: DailyAdapter) {
        thread {
            Thread.sleep(1000)
            run {
                dailyAdapter.notifyDataSetChanged()
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }
}