package com.test.module.home

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers


object Repository {
    fun searchRecommend(query:String)= liveData<String>(Dispatchers.IO){
        val result=try {
            val recommendResponse=RecommendNetwork.searchRecommend(query)
            val recommend=recommendResponse.itemList
            Result.success(recommend)
        }catch (e:Exception){
            Result.failure<List<RecommendResponse.Item>>(e)
        }
        emit(result.toString())
    }
}