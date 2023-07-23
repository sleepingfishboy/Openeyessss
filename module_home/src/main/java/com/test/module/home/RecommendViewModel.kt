package com.test.module.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.test.module.home.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RecommendViewModel : ViewModel() {
    private var disposable: Disposable? = null
    private var dataList: MutableLiveData<MutableList<RecommendResponse.Item>>? = null

    fun getData(): LiveData<MutableList<RecommendResponse.Item>> {
        if (dataList == null) {
            dataList = MutableLiveData()
        }
        return dataList!!
    }

    fun setDisposable() {
        disposable = ApiManager.getRecommend()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe { recommend ->
                setRecommendData(recommend.itemList)
            }
    }

    private fun setRecommendData(recommendItems: List<RecommendResponse.Item>) {
        val recommendList = mutableListOf<RecommendResponse.Item>()
        for (i in recommendItems.indices) {
            if (recommendItems[i].data.title != null)
                recommendList.add(recommendItems[i])
        }
        dataList?.value = recommendList
    }
}

