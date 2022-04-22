package com.yashkasera.groupnavigator.repository.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author yashkasera
 * Created 21/04/22 at 12:17 AM
 */
@Parcelize
data class Member(
    val id: String,
    val name: String,
    val phone: String,
    val email: String,
    val location: String,
):Parcelable
