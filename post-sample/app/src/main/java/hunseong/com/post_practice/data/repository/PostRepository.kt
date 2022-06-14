package hunseong.com.post_practice.data.repository

import hunseong.com.post_practice.data.api.PostApiService
import hunseong.com.post_practice.data.entity.Post
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import java.util.concurrent.Flow
import javax.inject.Inject
import javax.security.auth.callback.Callback
import kotlin.concurrent.thread

class PostRepository @Inject constructor(
    private val postApiService: PostApiService,
) : Repository {
    fun getPosts(): Single<List<Post>> {
        return postApiService.getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun createPosts(): Single<Void> {
        val input: HashMap<String, Any> = HashMap()
        input["userId"] = 1L
        input["title"] = "new!"
        input["body"] = "new post body body~"
        return postApiService.createPosts(input)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}
