package network

import com.test.module.square.Community
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET



interface ApiService {
    @GET("api/v7/community/tab/rec?refreshCount=0")
    fun getSquare():Observable<Community>
}