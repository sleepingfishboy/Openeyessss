package network


import com.test.module.square.*
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

    fun getAd():Observable<Advertisement>? {
        return apiService.getAd().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getExercise():Observable<Exercise>? {
        return apiService.getExercise().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getMusic():Observable<Music>? {
        return apiService.getMusic().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDrama():Observable<Drama>?{
        return apiService.getDrama().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getFunny():Observable<Funny>?{
        return apiService.getFunny().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getFood():Observable<Food>?{
        return apiService.getFood().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}