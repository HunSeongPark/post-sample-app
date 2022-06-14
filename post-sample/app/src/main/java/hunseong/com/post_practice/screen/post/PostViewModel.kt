package hunseong.com.post_practice.screen.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hunseong.com.post_practice.data.repository.PostRepository
import hunseong.com.post_practice.util.SingleLiveEvent
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class PostViewModel @Inject constructor(
    private val postRepository: PostRepository,
    @Named("errorEvent") private val errorEvent: SingleLiveEvent<Throwable>,
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _items = MutableLiveData<List<PostItem>>()
    val items: LiveData<List<PostItem>>
        get() = _items

    private val compositeDisposable = CompositeDisposable()

    fun loadPost() {
        compositeDisposable.add(postRepository.getPosts()
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .map {
                PostItem(it.userId, it.id, it.title, it.body)
            }
            .toList()
            .doOnSuccess {
                _loading.value = false
            }
            .subscribe(_items::setValue, errorEvent::setValue)
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}