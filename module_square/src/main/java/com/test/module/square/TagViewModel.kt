package com.test.module.square

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.ApiManager

class TagViewModel:ViewModel() {
    private var disposable:Disposable?=null
    private var dataList:MutableLiveData<MutableList<Advertisement.Item>>?=null

    fun getData():LiveData<MutableList<Advertisement.Item>>{
        if (dataList == null) {
            dataList = MutableLiveData()
        }
        return dataList!!
    }

    fun setDisposable(id:Int){
        when(id){
            1->disposable = ApiManager.getAd()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { data ->
                    setAdData(data.itemList)
                }
        }
    }

    private fun setAdData(adItems:List<Advertisement.Item>){
        val adList= mutableListOf<Advertisement.Item>()
        for (i in adItems.indices){
            if (adItems[i].data.content.data!=null)
                adList.add(adItems[i])
        }
        dataList?.value=adList
    }
}