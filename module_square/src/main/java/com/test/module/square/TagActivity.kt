package com.test.module.square

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/tag/activity")
class TagActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TagAdapter
    private lateinit var liveData: MutableLiveData<MutableList<Advertisement.Item>>

    private val viewModel by lazy { ViewModelProvider(this).get(TagViewModel::class.java)  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        recyclerView = findViewById(R.id.rv_tag)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        viewModel.setDisposable(1)
        liveData=viewModel.getData() as MutableLiveData<MutableList<Advertisement.Item>>
        liveData.observe(this, Observer { list->
            adapter=TagAdapter(list)
            recyclerView.adapter=adapter
        })
    }
}