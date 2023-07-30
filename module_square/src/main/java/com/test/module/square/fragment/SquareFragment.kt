package com.test.module.square.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselLayoutManager
import com.test.module.square.R
import com.test.module.square.adapter.SquareAdapter


class SquareFragment : Fragment() {
    private lateinit var list: List<String>
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
        carouselRecyclerView = view.findViewById(R.id.rv_square)
        carouselRecyclerView.layoutManager = CarouselLayoutManager()
        list = listOf("#广告", "#运动", "#音乐", "#剧情", "#搞笑", "#美食")
        carouselRecyclerView.adapter = SquareAdapter(list)
    }
}