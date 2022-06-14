package hunseong.com.post_practice.data.repository

import hunseong.com.post_practice.data.api.UserApiService
import hunseong.com.post_practice.data.entity.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApiService: UserApiService,
) : Repository {
    fun getUser(userId: Long): Single<User> {
        return userApiService.getUser(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}