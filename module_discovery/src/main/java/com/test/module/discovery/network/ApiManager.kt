package com.test.module.discovery.network

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers


/**
 *作者：sleepingfishboy
 *时间：2023/7/16

 */
object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }

    fun getMonthly(): Observable<Monthly>? {
        return apiService.getMonthly().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    fun getWeekly(): Observable<Weekly>? {
        return apiService.getWeekly().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    fun getTotal(): Observable<Total>? {
        return apiService.getTotal().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}