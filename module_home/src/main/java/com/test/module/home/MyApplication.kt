package com.test.module.home

import android.app.Application
import network.ApiRequest

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        recommendService=ApiRequest.getInstance().getApi()
    }
    companion object{
        lateinit var recommendService:RecommendService

        fun getRecommendApi():RecommendService{
            return recommendService
        }
    }
}