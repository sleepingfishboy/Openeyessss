package network

import com.example.lib.network.ApiService
import com.test.module.home.RecommendService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 *作者：sleepingfishboy
 *时间：2023/7/16

 */
object ApiRequest {
    private const val BASE_URL = "http://baobab.kaiyanapp.com/"
    private var apiRequest:ApiRequest?=null
    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Synchronized
    fun getInstance():ApiRequest{
        if (apiRequest==null){
            apiRequest=ApiRequest
        }
        return apiRequest!!
    }

    fun getApi():RecommendService{
        return retrofit.create(RecommendService::class.java)
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}