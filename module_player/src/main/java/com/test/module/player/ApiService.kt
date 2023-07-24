package com.test.module.player

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *作者：sleepingfishboy
 *时间：2023/7/23

 */
interface ApiService {
    @GET("api/v4/video/related")
    fun getRelatedVideos(@Query("id") id: String): Observable<Relevant>
    @GET("api/v4/video/related")
    fun getComments(@Query("id") id: String): Observable<Relevant>

}