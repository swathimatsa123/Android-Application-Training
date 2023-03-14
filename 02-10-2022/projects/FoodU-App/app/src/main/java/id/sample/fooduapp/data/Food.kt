package id.sample.fooduapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    var name: String,
    var description: String,
    var owner: String,
    var location: String,
    var distanceInKM: Double,
    var cost: Long,
    var rating: Float,
    var cover: Int
) : Parcelable