package com.test.module.home.network


import com.test.module.home.data.AllRec
import com.test.module.home.data.Daily
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("api/v5/index/tab/feed?num=100")
    fun getDaily():Observable<Daily>

    @GET("api/v5/index/tab/allRec")
    suspend fun searchRec(@Query("page")page:Int,@Query("per_page")perPage:Int): AllRec
}