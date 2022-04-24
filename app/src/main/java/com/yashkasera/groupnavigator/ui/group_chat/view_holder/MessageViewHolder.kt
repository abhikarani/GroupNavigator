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
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 22/04/22 at 1:45 AM
 */
sealed class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(messageItem: MessageItem)
    abstract fun setOnItemClickListener(listener: ItemClickListener<MessageItem>)

    class TextViewHolder(private val binding: ItemTextMessageBinding) :
        MessageViewHolder(binding.root) {
        private lateinit var clickListener: ItemClickListener<MessageItem>

        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.TextMessage
        }

        override fun setOnItemClickListener(listener: ItemClickListener<MessageItem>) {
            this.clickListener = listener
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
        private lateinit var clickListener: ItemClickListener<MessageItem>
        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.ImageMessage
        }

        override fun setOnItemClickListener(listener: ItemClickListener<MessageItem>) {
            clickListener = listener
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
        private lateinit var clickListener: ItemClickListener<MessageItem>

        override fun bind(messageItem: MessageItem) {
            (binding.card.layoutParams as ConstraintLayout.LayoutParams).horizontalBias =
                if (messageItem.sender == null) 1.0f else 0.0f
            binding.messageItem = messageItem as MessageItem.LocationMessage
            binding.viewLocation.setOnClickListener { clickListener.onItemClick(it, messageItem) }
        }

        override fun setOnItemClickListener(listener: ItemClickListener<MessageItem>) {
            clickListener = listener
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
        private lateinit var clickListener: ItemClickListener<MessageItem>
        override fun bind(messageItem: MessageItem) {

        }

        override fun setOnItemClickListener(listener: ItemClickListener<MessageItem>) {
            clickListener = listener
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
        private lateinit var clickListener: ItemClickListener<MessageItem>

        override fun bind(messageItem: MessageItem) {

        }

        override fun setOnItemClickListener(listener: ItemClickListener<MessageItem>) {
            clickListener = listener
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