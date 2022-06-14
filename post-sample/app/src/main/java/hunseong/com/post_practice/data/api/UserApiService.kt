package hunseong.com.post_practice.data.api

import hunseong.com.post_practice.data.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Long): Single<User>
}