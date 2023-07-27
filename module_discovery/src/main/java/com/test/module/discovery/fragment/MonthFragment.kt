package com.test.module.discovery.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.test.module.discovery.R
import com.test.module.discovery.adapter.MonthAdapter
import com.test.module.discovery.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MonthFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MonthAdapter
    private var disposable: Disposable? = null
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


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
        swipeRefreshLayout.setOnRefreshListener {
            loadData() // 在刷新时重新加载数据
        }
        loadData()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }

    private fun loadData() {
        disposable = ApiManager.getMonthly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnSubscribe { swipeRefreshLayout.isRefreshing = true } // 显示刷新状态
            ?.doFinally { swipeRefreshLayout.isRefreshing = false } // 隐藏刷新状态
            ?.subscribe({ monthly ->
                Log.d("ggg", monthly.itemList.toString())
                adapter.setMonthlyData(monthly.itemList)
            }, { error ->
                // 处理订阅过程中可能发生的错误
                error.printStackTrace()
                Toast.makeText(context, "看一下有没有联网哦~", Toast.LENGTH_SHORT).show()
                // 显示错误提示或执行其他适当的错误处理操作
            })
    }

}