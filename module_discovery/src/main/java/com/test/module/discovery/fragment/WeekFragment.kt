package com.test.module.discovery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.module.discovery.R
import com.test.module.discovery.adapter.WeekAdapter
import com.test.module.discovery.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers



class WeekFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WeekAdapter
    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_week, container, false)

        recyclerView = view.findViewById(R.id.rv_week)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = WeekAdapter()
        recyclerView.adapter = adapter

        disposable = ApiManager.getWeekly()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { weekly ->
                adapter.setWeeklyData(weekly.itemList)
            }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }
}