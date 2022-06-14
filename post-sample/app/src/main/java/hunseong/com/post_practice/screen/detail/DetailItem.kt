package hunseong.com.post_practice.screen.detail

import hunseong.com.post_practice.util.adapter.BaseModel
import hunseong.com.post_practice.util.adapter.CellType

data class DetailItem(
    override val id: Long,
    override val detailType: CellType,
    override val type: CellType = detailType,
    val value: Any,
) : BaseModel(id, type), DetailModel
