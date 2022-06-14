package hunseong.com.post_practice.screen.post

import android.os.Parcelable
import hunseong.com.post_practice.util.adapter.BaseModel
import hunseong.com.post_practice.util.adapter.CellType
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostItem(
    val userId: Long,
    override val id: Long,
    val title: String,
    val body: String,
    override val type: CellType = CellType.POST_CELL,
) : Parcelable, BaseModel(id, type)