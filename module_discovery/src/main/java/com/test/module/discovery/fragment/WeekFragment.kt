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
import com.test.module.discovery.adapter.WeekAdapter
import com.test.module.discovery.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class WeekFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WeekAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_week, container, false)

        swipeRefreshLayout = view.findViewById(R.id.srl_week)
        recyclerView = view.findViewById(R.id.rv_week)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = WeekAdapter()
        recyclerView.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener {
            loadData() // 在刷新时重新加载数据
        }

        loadData() // 默认加载数据


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }

    private fun loadData() {
        disposable = ApiManager.getWeekly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnSubscribe { swipeRefreshLayout.isRefreshing = true } // 显示刷新状态
            ?.doFinally { swipeRefreshLayout.isRefreshing = false } // 隐藏刷新状态
            ?.subscribe({ weekly ->
                Log.d("ggg", weekly.itemList.toString())
                adapter.setWeeklyData(weekly.itemList)

            }, { error ->

                error.printStackTrace()
                Toast.makeText(context, "看一下有没有联网哦~", Toast.LENGTH_SHORT).show()

            })
    }
}