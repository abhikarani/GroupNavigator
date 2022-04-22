package com.yashkasera.groupnavigator.ui.group_chat.view_holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.yashkasera.groupnavigator.databinding.ItemImageMessageBinding
import com.yashkasera.groupnavigator.databinding.ItemLoadingBinding
import com.yashkasera.groupnavigator.databinding.ItemLocationMessageBinding
import com.yashkasera.groupnavigator.databinding.ItemTextMessageBinding
import com.yashkasera.groupnavigator.repository.model.MessageItem

/**
 * @author yashkasera
 * Created 22/04/22 at 1:45 AM
 */
sealed class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(messageItem: MessageItem)

    class TextViewHolder(private val binding: ItemTextMessageBinding) :
        MessageViewHolder(binding.root) {
        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.TextMessage
        }

        companion object {
            fun create(parent: ViewGroup): TextViewHolder =
                TextViewHolder(
                    ItemTextMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    class ImageViewHolder(private val binding: ItemImageMessageBinding) :
        MessageViewHolder(binding.root) {
        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.ImageMessage
        }

        companion object {
            fun create(parent: ViewGroup): ImageViewHolder =
                ImageViewHolder(
                    ItemImageMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    class LocationViewHolder(private val binding: ItemLocationMessageBinding) :
        MessageViewHolder(binding.root) {
        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.LocationMessage
        }

        companion object {
            fun create(parent: ViewGroup): LocationViewHolder =
                LocationViewHolder(
                    ItemLocationMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    class DateViewHolder(parent: ViewGroup) : MessageViewHolder(parent) {
        override fun bind(messageItem: MessageItem) {

        }

        companion object {
            fun create(parent: ViewGroup): LocationViewHolder =
                LocationViewHolder(
                    ItemLocationMessageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    class LoadingViewHolder(binding: ItemLoadingBinding) : MessageViewHolder(binding.root) {
        override fun bind(messageItem: MessageItem) {

        }

        companion object {
            fun create(parent: ViewGroup): LoadingViewHolder =
                LoadingViewHolder(
                    ItemLoadingBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }
}