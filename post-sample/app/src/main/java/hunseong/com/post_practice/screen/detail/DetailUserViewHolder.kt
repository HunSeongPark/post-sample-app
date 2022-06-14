package hunseong.com.post_practice.screen.detail

import hunseong.com.post_practice.databinding.ItemDetailUserBinding
import hunseong.com.post_practice.util.adapter.AdapterListener
import hunseong.com.post_practice.util.adapter.BaseViewHolder

class DetailUserViewHolder(private val binding: ItemDetailUserBinding) :
    BaseViewHolder<DetailItem>(binding) {

    override fun reset() = Unit

    override fun bind(model: DetailItem, adapterListener: AdapterListener) {
        binding.user = model.value as UserItem
        binding.root.setOnClickListener {
            (adapterListener as UserListener).onUserClick(model.value)
        }
        binding.executePendingBindings()

    }
}