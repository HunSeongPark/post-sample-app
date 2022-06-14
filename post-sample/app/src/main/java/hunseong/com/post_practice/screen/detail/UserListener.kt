package hunseong.com.post_practice.screen.detail

import hunseong.com.post_practice.util.adapter.AdapterListener

interface UserListener : AdapterListener {
    fun onUserClick(user: UserItem)
}