package com.yashkasera.groupnavigator.ui.group_chat

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.yashkasera.groupnavigator.repository.model.Location
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.repository.model.MessageItem
import com.yashkasera.groupnavigator.ui.adapter.MessageAdapter
import java.sql.Timestamp

/**
 * @author yashkasera
 * Created 21/04/22 at 1:50 AM
 */
class GroupChatViewModel : ViewModel() {
    val isLocationShared = ObservableBoolean(false)
    val messages = listOf<MessageItem>(
        MessageItem.TextMessage(
            "1",
            Member("1", "Yash", "9648111905", "", ""),
            Timestamp(System.currentTimeMillis()),
            "Hello"
        ),
        MessageItem.TextMessage(
            "2",
            Member("1", "Yash", "9648111905", "", ""),
            Timestamp(System.currentTimeMillis()),
            "How are you?"
        ),
        MessageItem.TextMessage(
            "7",
            null,
            Timestamp(System.currentTimeMillis()),
            "Heya! How are you?"
        ),
        MessageItem.TextMessage(
            "3",
            Member("1", "Akshat", "9648111905", "", ""),
            Timestamp(System.currentTimeMillis()),
            "I am sharing my location"
        ),
        MessageItem.LocationMessage(
            "3",
            Member("1", "Yash", "9648111905", "", ""),
            Timestamp(System.currentTimeMillis()),
            Location(22.7, 75.8)
        ),
    )
    val messageAdapter = MessageAdapter()
    init {
        messageAdapter.submitList(messages)
    }
}