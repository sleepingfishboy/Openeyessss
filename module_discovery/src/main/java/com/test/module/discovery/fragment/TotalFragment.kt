package com.test.module.discovery.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.module.discovery.R
import com.test.module.discovery.adapter.TotalAdapter
import com.test.module.discovery.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class TotalFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TotalAdapter
    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_total, container, false)

        recyclerView = view.findViewById(R.id.rv_total)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = TotalAdapter()
        recyclerView.adapter = adapter

        disposable = ApiManager.getTotal()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { total ->
                adapter.setTotalData(total.itemList)
            }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }
}