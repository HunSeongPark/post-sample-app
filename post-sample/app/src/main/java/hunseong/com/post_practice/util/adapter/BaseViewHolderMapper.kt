package hunseong.com.post_practice.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import hunseong.com.post_practice.databinding.ItemDetailCommentBinding
import hunseong.com.post_practice.databinding.ItemDetailPostBinding
import hunseong.com.post_practice.databinding.ItemDetailUserBinding
import hunseong.com.post_practice.databinding.ItemPostBinding
import hunseong.com.post_practice.screen.detail.DetailCommentViewHolder
import hunseong.com.post_practice.screen.detail.DetailPostViewHolder
import hunseong.com.post_practice.screen.detail.DetailUserViewHolder
import hunseong.com.post_practice.screen.post.PostViewHolder

object BaseViewHolderMapper {

    fun <M : BaseModel> map(
        parent: ViewGroup,
        type: CellType,
    ): BaseViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)

        val viewHolder = when (type) {
            CellType.POST_CELL -> PostViewHolder(
                ItemPostBinding.inflate(inflater, parent, false)
            )
            CellType.DETAIL_USER_CELL -> DetailUserViewHolder(
                ItemDetailUserBinding.inflate(inflater, parent, false)
            )
            CellType.DETAIL_POST_CELL -> DetailPostViewHolder(
                ItemDetailPostBinding.inflate(inflater, parent, false)
            )
            CellType.DETAIL_COMMENT_CELL -> DetailCommentViewHolder(
                ItemDetailCommentBinding.inflate(inflater, parent, false)
            )
        }

        return viewHolder as BaseViewHolder<M>
    }
}