package com.yashkasera.groupnavigator.repository.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author yashkasera
 * Created 22/04/22 at 1:18 AM
 */
@Parcelize
sealed class MessageItem(val id: String, val sender: Member?, val timestamp: Long) :
    Parcelable {

    data class TextMessage(
        val id1: String,
        val sender1: Member? = null,
        val timestamp1: Long,
        val text: String
    ) : MessageItem(id1, sender1, timestamp1)

    data class ImageMessage(
        val id1: String,
        val sender1: Member? = null,
        val timestamp1: Long, val imageUrl: String
    ) : MessageItem(id1, sender1, timestamp1)

    data class LocationMessage(
        val id1: String,
        val sender1: Member? = null,
        val timestamp1: Long,
        val location: Location
    ) : MessageItem(id1, sender1, timestamp1)

    data class DateMessage(val id1: String, val timestamp1: Long) :
        MessageItem(id1, null, timestamp1)

    object Loading : MessageItem("", null, 0L)

    @SuppressLint("SimpleDateFormat")
    fun getTime(): String {
        return SimpleDateFormat("hh:mm a").format(Date(timestamp))
    }
}
