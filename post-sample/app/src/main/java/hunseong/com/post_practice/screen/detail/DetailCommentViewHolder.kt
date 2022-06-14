package hunseong.com.post_practice.screen.detail

import hunseong.com.post_practice.data.entity.Comment
import hunseong.com.post_practice.databinding.ItemDetailCommentBinding
import hunseong.com.post_practice.util.adapter.AdapterListener
import hunseong.com.post_practice.util.adapter.BaseViewHolder

class DetailCommentViewHolder(private val binding: ItemDetailCommentBinding) :
    BaseViewHolder<DetailItem>(binding) {

    override fun reset() = Unit

    override fun bind(model: DetailItem, adapterListener: AdapterListener) {
        binding.comment = model.value as Comment
        binding.executePendingBindings()
    }
}