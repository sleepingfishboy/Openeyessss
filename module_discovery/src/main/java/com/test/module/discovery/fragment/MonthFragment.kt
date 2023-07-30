package com.test.module.discovery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.test.module.discovery.viewmodel.DiscoveryViewModel
import com.test.module.discovery.R
import com.test.module.discovery.adapter.MonthAdapter


class MonthFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MonthAdapter

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    // 声明MonthViewModel实例
    private val monthViewModel: DiscoveryViewModel by lazy {
        ViewModelProvider(this)[DiscoveryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_month, container, false)
        swipeRefreshLayout = view.findViewById(R.id.srl_month)

        recyclerView = view.findViewById(R.id.rv_month)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = MonthAdapter()
        recyclerView.adapter = adapter
        swipeRefreshLayout.setColorSchemeResources(com.test.module.home.R.color.pink)




        swipeRefreshLayout.setOnRefreshListener {
            loadData() // 在刷新时重新加载数据
        }
        loadData()
        observeViewModel() // 监听数据变化
        return view
    }

    //取消正在进行的数据加载请求
    override fun onDestroyView() {
        super.onDestroyView()
        monthViewModel.cancelDataRequest() // 取消数据加载请求
    }

    private fun loadData() {
        monthViewModel.loadMonthlyData()
    }

    private fun observeViewModel() {
        // 观察monthlyData的变化，更新列表数据
        monthViewModel.getMonthlyData().observe(viewLifecycleOwner) { monthlyList ->
            adapter.setMonthlyData(monthlyList)
            swipeRefreshLayout.isRefreshing = false // 停止刷新动画
        }
    }

}