package com.test.module.discovery.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


/**
 *作者：sleepingfishboy
 *时间：2023/7/15

 */
interface ApiService {


    @GET("api/v4/rankList/videos?strategy=weekly")
    fun getWeekly(): Observable<Weekly>

    @GET("api/v4/rankList/videos?strategy=monthly")
    fun getMonthly(): Observable<Monthly>

    @GET("api/v4/rankList/videos?strategy=historical")
    fun getTotal(): Observable<Total>
}