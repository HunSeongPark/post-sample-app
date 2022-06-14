package hunseong.com.post_practice.data.entity

data class Comment(
    val postId: Long,
    val id: Long,
    val name: String,
    val email: String,
    val body: String,
)