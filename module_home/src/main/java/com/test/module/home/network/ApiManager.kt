package com.test.module.home.network

import com.test.module.home.Daily
import com.test.module.home.RecommendResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers



object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }

    fun getRecommend(): Observable<RecommendResponse>? {
        return apiService.getRecommend().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDaily(): Observable<Daily>? {
        return apiService.getDaily().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}