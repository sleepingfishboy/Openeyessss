package com.test.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.module.home.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DailyViewModel:ViewModel() {
    private var disposable: Disposable? = null
    private var dataList: MutableLiveData<MutableList<Item>>?=null

    fun getData(): LiveData<MutableList<Item>> {
        if (dataList==null){
            dataList= MutableLiveData()
        }
        return dataList!!
    }

    fun setDisposable(){
        disposable = ApiManager.getDaily()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { daily->
                setDailyData(daily.itemList)
            }
    }

    private fun setDailyData(recommendItems: List<Item>) {
        val recommendList= mutableListOf<Item>()
        for(i in recommendItems.indices){
            if (recommendItems[i].data.content!=null)
                recommendList.add(recommendItems[i])
        }
        dataList?.value =recommendList
    }
}