package com.test.module.player.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.module.player.data.RelevantBean
import com.test.module.player.network.ApiManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *作者：sleepingfishboy
 *时间：2023/7/30

 */
class PlayerMainViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val Videos: MutableLiveData<List<RelevantBean.Item>> = MutableLiveData()
    val relevantVideos: LiveData<List<RelevantBean.Item>>
        get() = Videos

    // 在这里进行数据的获取和处理
    fun loadRelevantVideos(id: String) {
        val disposable = ApiManager.getRelatedVideos(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({ relevantVideos ->
                Videos.value = relevantVideos.itemList
            }, { error ->
                // 处理订阅过程中可能发生的错误
                error.printStackTrace()
            })

        disposable?.let {
            compositeDisposable.add(it)
        }
    }

    public override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}