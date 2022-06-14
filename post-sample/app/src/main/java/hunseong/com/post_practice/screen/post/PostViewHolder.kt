package hunseong.com.post_practice.screen.post

import hunseong.com.post_practice.databinding.ItemPostBinding
import hunseong.com.post_practice.util.adapter.AdapterListener
import hunseong.com.post_practice.util.adapter.BaseViewHolder

class PostViewHolder(private val binding: ItemPostBinding) : BaseViewHolder<PostItem>(binding) {

    override fun reset() = Unit

    override fun bind(model: PostItem, adapterListener: AdapterListener) {
        binding.post = model
        binding.root.setOnClickListener {
            (adapterListener as PostListener).onPostClick(model)
        }
        binding.executePendingBindings()
    }

}