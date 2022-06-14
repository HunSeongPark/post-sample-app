package hunseong.com.post_practice.util.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

abstract class BaseModel(
    open val id: Long,
    open val type: CellType,
) {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<BaseModel>() {

            override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean {
                return oldItem === newItem
            }

        }
    }
}