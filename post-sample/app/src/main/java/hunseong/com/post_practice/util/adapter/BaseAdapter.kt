package hunseong.com.post_practice.util.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class BaseAdapter<M : BaseModel>(
    private var modelList: List<BaseModel>,
    private val adapterListener: AdapterListener,
) : ListAdapter<BaseModel, BaseViewHolder<M>>(BaseModel.DIFF_UTIL) {

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<M> {
        return BaseViewHolderMapper.map(parent, CellType.values()[viewType])
    }

    override fun onBindViewHolder(holder: BaseViewHolder<M>, position: Int) {
        holder.bind(modelList[position] as M, adapterListener)
    }

    override fun submitList(list: List<BaseModel>?) {
        list?.let {
            modelList = it
        }
        super.submitList(list)
    }

}