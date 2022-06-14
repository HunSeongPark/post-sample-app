package hunseong.com.post_practice.screen.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hunseong.com.post_practice.screen.detail.UserItem
import hunseong.com.post_practice.util.SingleLiveEvent
import javax.inject.Inject
import javax.inject.Named

class UserViewModel @Inject constructor(
    @Named("errorEvent") private val errorEvent: SingleLiveEvent<Throwable>,
) : ViewModel() {

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _user = MutableLiveData<UserItem?>(null)
    val user: LiveData<UserItem?>
        get() = _user

    fun setUser(user: UserItem?) {
        user?.let {
            _user.value = user
        } ?: kotlin.run {
            errorEvent.value = NullPointerException()
        }
        _loading.value = false
    }
}