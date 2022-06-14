package hunseong.com.post_practice.data.api

import hunseong.com.post_practice.data.entity.Comment
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentApiService {

    @GET("comments")
    fun getComments(@Query("postId") postId: Long): Single<List<Comment>>
}