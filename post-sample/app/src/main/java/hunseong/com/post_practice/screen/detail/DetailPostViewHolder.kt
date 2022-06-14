package hunseong.com.post_practice.screen.detail

import hunseong.com.post_practice.databinding.ItemDetailPostBinding
import hunseong.com.post_practice.screen.post.PostItem
import hunseong.com.post_practice.util.adapter.AdapterListener
import hunseong.com.post_practice.util.adapter.BaseViewHolder

class DetailPostViewHolder(private val binding: ItemDetailPostBinding) :
    BaseViewHolder<DetailItem>(binding) {

    override fun reset() = Unit

    override fun bind(model: DetailItem, adapterListener: AdapterListener) {
        binding.post = model.value as PostItem
        binding.executePendingBindings()
    }
}