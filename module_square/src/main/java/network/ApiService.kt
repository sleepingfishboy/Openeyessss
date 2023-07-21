package network

import com.test.module.square.Square
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET



interface ApiService {
    @GET("api/v5/index/tab/ugcSelected")
    fun getSquare():Observable<Square>
}