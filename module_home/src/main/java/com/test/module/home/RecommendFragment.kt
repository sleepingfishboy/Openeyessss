package com.test.module.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.*
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import com.test.module.home.network.ApiManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class RecommendFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var progressBar: ProgressBar
    private val rvAdapter=RvAdapter()
    private val viewModel by lazy { ViewModelProvider(this).get(RecommendViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh_recommend)
        progressBar=view.findViewById(R.id.progress_bar)
        recyclerView=requireView().findViewById(R.id.rv_recommend)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=rvAdapter
        lifecycleScope.launch{
            viewModel.getPagingData().collect { pagingData->
                rvAdapter.submitData(pagingData)
            }
        }
        rvAdapter.addLoadStateListener {
            when(it.refresh){
                is LoadState.NotLoading->{
                    progressBar.visibility=View.INVISIBLE
                    recyclerView.visibility=View.VISIBLE
                }
                is LoadState.Loading->{
                    progressBar.visibility=View.VISIBLE
                    recyclerView.visibility=View.INVISIBLE
                }
                is LoadState.Error->{
                    val state=it.refresh as LoadState.Error
                    progressBar.visibility=View.INVISIBLE
                    Log.d("recommend", "error = ${state.error.message}: ")
                }
            }
        }
        swipeRefreshLayout.setOnRefreshListener {
            refresh(rvAdapter)
        }
    }

    private fun refresh(rvAdapter: RvAdapter) {
        thread {
            Thread.sleep(1000)
            run {
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }
}