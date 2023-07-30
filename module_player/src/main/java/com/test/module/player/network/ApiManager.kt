package com.test.module.player.network

import com.test.module.player.data.CommentBean
import com.test.module.player.data.RelevantBean
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *作者：sleepingfishboy
 *时间：2023/7/23

 */
object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }
    fun getRelatedVideos(id: String): Observable<RelevantBean>? {
        return apiService.getRelatedVideos(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    fun getComments(videoId: String): Observable<CommentBean>? {
        return apiService.getComments(videoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}