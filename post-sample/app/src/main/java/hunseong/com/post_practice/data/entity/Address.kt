package hunseong.com.post_practice.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo,
) : Parcelable {
    fun toStringFormat(): String {
        return String.format("%s, %s, %s", suite, street, city)
    }
}
