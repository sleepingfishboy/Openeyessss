package network


import com.test.module.square.Community
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers



object ApiManager {
    private val apiService: ApiService by lazy {
        ApiRequest.apiService
    }

    fun getSquare(): Observable<Community>? {
        return apiService.getSquare().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}