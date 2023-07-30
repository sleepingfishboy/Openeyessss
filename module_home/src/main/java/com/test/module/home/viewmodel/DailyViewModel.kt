package com.test.module.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.test.module.home.data.Item
import com.test.module.home.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class DailyViewModel : ViewModel() {
    private var disposable: Disposable? = null
    private var dataList: MutableLiveData<MutableList<Item>>? = null


    fun getData(): LiveData<MutableList<Item>> {
        if (dataList == null) {
            dataList = MutableLiveData()
        }
        return dataList!!
    }

    fun setDisposable(swipeRefreshLayout: SwipeRefreshLayout) {
        disposable = ApiManager.getDaily()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnSubscribe { swipeRefreshLayout.isRefreshing = true }
            ?.doFinally { swipeRefreshLayout.isRefreshing = false }
            ?.subscribe({ daily ->
                setDailyData(daily.itemList)
            },
                { throwable ->
                    // 错误处理逻辑
                    Log.e("TAG", "发生异常：$throwable")
                })
    }

    private fun setDailyData(dailyItems: List<Item>) {
        val dailyList = mutableListOf<Item>()
        for (i in dailyItems.indices) {
            if (dailyItems[i].data.content != null)
                dailyList.add(dailyItems[i])
        }
        dataList?.value = dailyList
    }
}