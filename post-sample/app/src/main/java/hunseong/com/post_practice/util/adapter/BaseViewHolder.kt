package hunseong.com.post_practice.util.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<M : BaseModel>(
    binding: ViewDataBinding,
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bind(model: M, adapterListener: AdapterListener) {
        reset()
    }
}