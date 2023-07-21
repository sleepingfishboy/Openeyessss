package com.test.module.square

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.ApiManager

class SquareViewModel:ViewModel() {
    private var disposable: Disposable? = null
    private var dataList:MutableLiveData<MutableList<Item>> ?=null

    fun getData(): LiveData<MutableList<Item>> {
        if (dataList==null){
            dataList= MutableLiveData()
        }
        return dataList!!
    }

    fun setDisposable(){
        disposable = ApiManager.getSquare()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { square->
                setSquareData(square.itemList)
            }
    }

    private fun setSquareData(squareItems: List<Item>) {
        val squareList= mutableListOf<Item>()
        for(i in squareItems.indices){
            if (squareItems[i].data.content!=null)
                squareList.add(squareItems[i])
        }
        dataList?.value =squareList
    }
}