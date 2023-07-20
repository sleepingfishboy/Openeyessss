package com.test.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class RecommendViewModel:ViewModel() {
    val recommendLiveData=MutableLiveData<String>()

    val recommendList = ArrayList<Recommend.Item>()


}