package com.test.module.square

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.ApiManager

class SquareViewModel:ViewModel() {
    private var dataList:MutableLiveData<List<String>> ?=null

    fun getData(): LiveData<List<String>> {
        if (dataList==null){
            dataList= MutableLiveData()
        }
        return dataList!!
    }

}