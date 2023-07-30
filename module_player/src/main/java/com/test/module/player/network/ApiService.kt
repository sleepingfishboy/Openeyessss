package com.test.module.player.network

import com.test.module.player.data.CommentBean
import com.test.module.player.data.RelevantBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *作者：sleepingfishboy
 *时间：2023/7/23

 */
interface ApiService {
    @GET("api/v4/video/related")
    fun getRelatedVideos(@Query("id") id: String): Observable<RelevantBean>
    @GET("api/v2/replies/video")
    fun getComments(@Query("videoId") videoId: String): Observable<CommentBean>

}