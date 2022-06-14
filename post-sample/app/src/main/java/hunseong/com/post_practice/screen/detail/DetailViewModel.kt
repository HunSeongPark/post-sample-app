package hunseong.com.post_practice.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hunseong.com.post_practice.data.repository.CommentRepository
import hunseong.com.post_practice.data.repository.UserRepository
import hunseong.com.post_practice.screen.post.PostItem
import hunseong.com.post_practice.util.SingleLiveEvent
import hunseong.com.post_practice.util.adapter.CellType
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class DetailViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val commentRepository: CommentRepository,
    @Named("errorEvent") private val errorEvent: SingleLiveEvent<Throwable>,
) : ViewModel() {

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _detailItems = MutableLiveData<List<DetailItem>>()
    val detailItems: LiveData<List<DetailItem>>
        get() = _detailItems

    private val compositeDisposable = CompositeDisposable()

    fun loadData(post: PostItem?) {
        try {
            compositeDisposable.add(Single.zip(
                userRepository.getUser(post!!.userId),
                Single.just(post),
                commentRepository.getComments(post.id), { user, p, comments ->
                    val list = mutableListOf<DetailItem>()
                    list.add(DetailItem(user.id,
                        CellType.DETAIL_USER_CELL,
                        value = UserItem(
                            user.id,
                            user.name,
                            user.username,
                            user.email,
                            user.address,
                            user.phone,
                            user.website,
                            user.company,
                        )))
                    list.add(DetailItem(p.id, CellType.DETAIL_POST_CELL, value = p))
                    comments.forEach {
                        list.add(DetailItem(it.id, CellType.DETAIL_COMMENT_CELL, value = it))
                    }
                    return@zip list
                }
            )
                .retry(2)
                .doOnSuccess {
                    _loading.value = false
                }
                .subscribe(_detailItems::setValue, errorEvent::setValue)
            )
        } catch (e: Exception) {
            errorEvent.value = e
        }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}