package com.test.module.home.network

import RecPagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.module.home.AllRec
import com.test.module.home.Daily
import com.test.module.home.RecommendResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow


object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }

    private const val PAGE_SIZE=50

    fun getRecommend(): Observable<RecommendResponse>? {
        return apiService.getRecommend().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDaily(): Observable<Daily>? {
        return apiService.getDaily().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getPagingData(): Flow<PagingData<AllRec.Item>>{
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            pagingSourceFactory = {RecPagingSource(apiService)}
        ).flow
    }
}