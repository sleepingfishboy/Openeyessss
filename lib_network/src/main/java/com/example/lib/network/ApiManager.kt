package com.example.lib.network

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


/**
 *作者：sleepingfishboy
 *时间：2023/7/16

 */
object ApiManager {
    private val apiService: com.example.lib.network.ApiService by lazy {
        com.example.lib.network.ApiRequest.apiService
    }

    fun getRecommend(): Observable<Recommend>? {
        return apiService.getRecommend()?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
    }

}