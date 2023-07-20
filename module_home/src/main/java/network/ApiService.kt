package network


import com.test.module.home.Recommend
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET



interface ApiService {
    @GET("api/v5/index/tab/allRec")
    fun getRecommend(): Observable<Recommend>
}