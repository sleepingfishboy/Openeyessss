package com.test.module.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.ApiManager

class RecommendFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var rvAdapter: RvAdapter
    private var disposable: Disposable? = null

    val viewModel by lazy { ViewModelProvider(this).get(RecommendViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        disposable = ApiManager.getRecommend()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { recommend->
                rvAdapter.setRecommendData(recommend.itemList)
                Log.d("z",recommend.itemList.toString())
            }
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

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }
}