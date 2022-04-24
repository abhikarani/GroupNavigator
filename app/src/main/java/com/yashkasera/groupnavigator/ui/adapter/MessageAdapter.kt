package com.yashkasera.groupnavigator.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yashkasera.groupnavigator.repository.model.MessageItem
import com.yashkasera.groupnavigator.ui.group_chat.view_holder.MessageViewHolder
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 22/04/22 at 1:28 AM
 */
class MessageAdapter :
    ListAdapter<MessageItem, MessageViewHolder>(MessageDiffCallback) {
    private lateinit var itemClickListener: ItemClickListener<MessageItem>

    object MessageDiffCallback : DiffUtil.ItemCallback<MessageItem>() {
        override fun areItemsTheSame(oldItem: MessageItem, newItem: MessageItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MessageItem, newItem: MessageItem): Boolean =
            oldItem == newItem
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return when (viewType) {
            TEXT -> MessageViewHolder.TextViewHolder.create(parent)
            IMAGE -> MessageViewHolder.ImageViewHolder.create(parent)
            LOCATION -> MessageViewHolder.LocationViewHolder.create(parent)
            LOADING -> MessageViewHolder.LoadingViewHolder.create(parent)
            DATE -> MessageViewHolder.TextViewHolder.create(parent)
            else -> MessageViewHolder.TextViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) =
        holder.bind(getItem(position)).also {
            holder.setOnItemClickListener(itemClickListener)
        }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MessageItem.TextMessage -> TEXT
            is MessageItem.ImageMessage -> IMAGE
            is MessageItem.LocationMessage -> LOCATION
            is MessageItem.DateMessage -> DATE
            is MessageItem.Loading -> LOADING
        }
    }

    fun setListener(itemClickListener: ItemClickListener<MessageItem>) {
        this.itemClickListener = itemClickListener
    }

    companion object {
        private const val TEXT = 0
        private const val LOCATION = 1
        private const val IMAGE = 2
        private const val DATE = 3
        private const val LOADING = 4
    }
}