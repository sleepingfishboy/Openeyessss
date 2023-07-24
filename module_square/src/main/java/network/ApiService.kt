package network

import com.test.module.square.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET



interface ApiService {
    @GET("api/v7/community/tab/rec?refreshCount=0")
    fun getSquare():Observable<Community>

    @GET("api/v1/tag/videos?id=16")
    fun getAd():Observable<Advertisement>

    @GET("api/v1/tag/videos?id=4")
    fun getExercise():Observable<Exercise>

    @GET("api/v1/tag/videos?id=18")
    fun getMusic():Observable<Music>

    @GET("api/v1/tag/videos?id=12")
    fun getDrama():Observable<Drama>

    @GET("api/v1/tag/videos?id=140")
    fun getFunny():Observable<Funny>

    @GET("api/v1/tag/videos?id=20")
    fun getFood():Observable<Food>
}