package com.test.module.home

import android.database.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendService {
    @GET("api/v5/index/tab/allRec")
    fun getRecommend(@Query("query")query:String): Observable<RecommendResponse>
}