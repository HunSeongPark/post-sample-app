package hunseong.com.post_practice.data.repository

import hunseong.com.post_practice.data.api.PostApiService
import hunseong.com.post_practice.data.entity.Post
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApiService: PostApiService,
) : Repository {
    fun getPosts(): Single<List<Post>> {
        return postApiService.getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}