package com.test.module.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lib.network.ApiManager

class HomeMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        ApiManager.getRecommend()?.subscribe { hotWords ->
            // 处理返回的数据
        }?.let { disposable ->

        }
    }
}