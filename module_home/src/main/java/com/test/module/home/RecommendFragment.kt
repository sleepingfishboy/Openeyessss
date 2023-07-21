package com.test.module.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.test.module.home.network.ApiManager
import kotlin.concurrent.thread

class RecommendFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var rvAdapter: RvAdapter
    private lateinit var liveData:MutableLiveData<MutableList<RecommendResponse.Item>>

    private val viewModel by lazy { ViewModelProvider(this).get(RecommendViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.setDisposable()
        liveData =viewModel.getData() as MutableLiveData<MutableList<RecommendResponse.Item>>
        liveData.observe(this, Observer { recommendList->
            rvAdapter=RvAdapter(recommendList)
            recyclerView.adapter=rvAdapter
            swipeRefreshLayout.setColorSchemeResources(R.color.black)
            swipeRefreshLayout.setOnRefreshListener {
                refresh(RvAdapter(recommendList))
            }
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
        swipeRefreshLayout=view.findViewById(R.id.swipeRefresh_recommend)
        recyclerView= requireView().findViewById(R.id.rv_recommend)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager
    }

    private fun refresh(rvAdapter: RvAdapter){
        thread {
            Thread.sleep(1000)
            run{
                rvAdapter.notifyDataSetChanged()
                swipeRefreshLayout.isRefreshing=false
            }
        }
    }
}