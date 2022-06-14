package hunseong.com.post_practice.screen.post

import hunseong.com.post_practice.util.adapter.AdapterListener

interface PostListener : AdapterListener {
    fun onPostClick(post: PostItem)
}