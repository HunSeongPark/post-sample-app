package hunseong.com.post_practice.data.api

import hunseong.com.post_practice.data.entity.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApiService {

    @GET("posts")
    fun getPosts(): Single<List<Post>>

}