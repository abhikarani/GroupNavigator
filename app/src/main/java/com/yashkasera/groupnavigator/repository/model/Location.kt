package com.yashkasera.groupnavigator.repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author yashkasera
 * Created 22/04/22 at 1:26 AM
 */
@Parcelize
data class Location(
    val latitude: Double,
    val longitude: Double
) : Parcelable
