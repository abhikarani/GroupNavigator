package com.yashkasera.groupnavigator.ui.group_chat

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.yashkasera.groupnavigator.repository.model.Location
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.repository.model.MessageItem
import com.yashkasera.groupnavigator.ui.adapter.MessageAdapter

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
            System.currentTimeMillis(),
            "Hello"
        ),
        MessageItem.TextMessage(
            "2",
            Member("1", "Yash", "9648111905", "", ""),
            System.currentTimeMillis() + 5000,
            "How are you?"
        ),
        MessageItem.TextMessage(
            "7",
            null,
            System.currentTimeMillis() + 7500,
            "Heya! How are you?"
        ),
        MessageItem.TextMessage(
            "3",
            Member("1", "Akshat", "9648111905", "", ""),
            System.currentTimeMillis() + 10000,
            "I am sharing my location"
        ),
        MessageItem.LocationMessage(
            "3",
            Member("1", "Yash", "9648111905", "", ""),
            System.currentTimeMillis() + 15000,
            Location(22.7, 75.8)
        ),
    )
    val messageAdapter = MessageAdapter()

    init {
        messageAdapter.submitList(messages)
    }
}