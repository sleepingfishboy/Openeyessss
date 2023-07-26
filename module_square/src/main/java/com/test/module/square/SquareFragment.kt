package com.test.module.square

import android.content.Intent
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
import com.google.android.material.carousel.CarouselLayoutManager
import kotlin.concurrent.thread


class SquareFragment : Fragment() {
    private val viewModel by lazy { ViewModelProvider(this)[SquareViewModel::class.java] }
    private lateinit var list: List<Int>
    private lateinit var carouselRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        carouselRecyclerView=view.findViewById(R.id.rv_square)
        carouselRecyclerView.layoutManager=CarouselLayoutManager()
        list= mutableListOf(R.drawable.ad,R.drawable.exercise,R.drawable.music,R.drawable.drama,R.drawable.funny,R.drawable.food)
        carouselRecyclerView.adapter=SquareAdapter(list)
    }
}