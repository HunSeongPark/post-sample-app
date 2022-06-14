package hunseong.com.post_practice.screen.detail

import android.os.Parcelable
import hunseong.com.post_practice.data.entity.Address
import hunseong.com.post_practice.data.entity.Company
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserItem(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company,
) : Parcelable