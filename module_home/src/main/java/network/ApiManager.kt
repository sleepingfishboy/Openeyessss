package network

import com.test.module.home.Recommend
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers



object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }

    fun getRecommend(): Observable<Recommend>? {
        return apiService.getRecommend().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}