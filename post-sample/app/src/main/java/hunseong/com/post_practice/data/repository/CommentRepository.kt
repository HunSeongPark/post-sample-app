package hunseong.com.post_practice.data.repository

import hunseong.com.post_practice.data.api.CommentApiService
import hunseong.com.post_practice.data.entity.Comment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val commentApiService: CommentApiService,
) : Repository {
    fun getComments(postId: Long): Single<List<Comment>> {
        return commentApiService.getComments(postId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}