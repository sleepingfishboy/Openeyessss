package com.test.module.square

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.concurrent.thread


class SquareFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var squareAdapter: SquareAdapter
    private lateinit var liveData:MutableLiveData<MutableList<Item>>

    private val viewModel by lazy { ViewModelProvider(this)[SquareViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        liveData =viewModel.getData() as MutableLiveData<MutableList<Item>>
        liveData.observe(this, Observer { squareList->
            squareAdapter=SquareAdapter(squareList)
            recyclerView.adapter=squareAdapter
            swipeRefreshLayout.setColorSchemeResources(R.color.black)
            swipeRefreshLayout.setOnRefreshListener {
                refresh(SquareAdapter(squareList))
            }
        })
        viewModel.setDisposable()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_square, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout)
        recyclerView=view.findViewById(R.id.rv_square)
        val layoutManager= GridLayoutManager(context,2)
        recyclerView.layoutManager=layoutManager
    }

    private fun refresh(squareAdapter: SquareAdapter){
        thread {
            Thread.sleep(1000)
            run{
                squareAdapter.notifyDataSetChanged()
                swipeRefreshLayout.isRefreshing=false
            }
        }
    }
}