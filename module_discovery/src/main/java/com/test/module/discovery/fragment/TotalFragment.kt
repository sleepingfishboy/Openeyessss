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
import com.test.module.discovery.R
import com.test.module.discovery.adapter.TotalAdapter
import com.test.module.discovery.viewmodel.DiscoveryViewModel


class TotalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TotalAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val totalViewModel: DiscoveryViewModel by lazy {
        ViewModelProvider(this)[DiscoveryViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_total, container, false)
        swipeRefreshLayout = view.findViewById(R.id.srl_total)
        recyclerView = view.findViewById(R.id.rv_total)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        swipeRefreshLayout.setColorSchemeResources(com.test.module.home.R.color.pink)

        adapter = TotalAdapter()
        recyclerView.adapter = adapter
        swipeRefreshLayout.setOnRefreshListener {
            loadData() // 在刷新时重新加载数据
        }
        loadData()
        observeViewModel() // 监听数据变化
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        totalViewModel.cancelDataRequest() // 取消数据加载请求
    }

    private fun loadData() {
        totalViewModel.loadTotalData()
    }
    private fun observeViewModel() {
        // 观察monthlyData的变化，更新列表数据
        totalViewModel.getTotalData().observe(viewLifecycleOwner) { totalList ->
            adapter.setTotalData(totalList)
            swipeRefreshLayout.isRefreshing = false // 停止刷新动画
        }
    }
}