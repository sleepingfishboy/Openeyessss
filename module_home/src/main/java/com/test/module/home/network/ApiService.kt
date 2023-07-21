package com.test.module.home.network


import com.test.module.home.Daily
import com.test.module.home.RecommendResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET



interface ApiService {
    @GET("api/v5/index/tab/allRec")
    fun getRecommend(): Observable<RecommendResponse>

    @GET("api/v5/index/tab/feed")
    fun getDaily():Observable<Daily>
}