package com.yashkasera.groupnavigator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yashkasera.groupnavigator.databinding.ItemGroupBinding
import com.yashkasera.groupnavigator.repository.model.Group
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 21/04/22 at 12:15 AM
 */
class GroupAdapter : ListAdapter<Group, GroupAdapter.GroupViewHolder>(GroupDiffCallback) {
    private lateinit var clickListener: ItemClickListener<Group>

    class GroupViewHolder(private val binding: ItemGroupBinding, private val clickListener: ItemClickListener<Group>) : RecyclerView.ViewHolder(binding.root) {
        fun bind(group: Group) {
            binding.group = group
            binding.root.setOnClickListener { clickListener.onItemClick(item = group) }
        }

        companion object {
            fun create(parent: ViewGroup, clickListener: ItemClickListener<Group>): GroupViewHolder {
                return GroupViewHolder(
                    ItemGroupBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    clickListener
                )
            }
        }
    }

    fun setClickListener(clickListener: ItemClickListener<Group>) {
        this.clickListener = clickListener
    }

    object GroupDiffCallback : DiffUtil.ItemCallback<Group>() {
        override fun areItemsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Group, newItem: Group): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroupViewHolder {
        return GroupViewHolder.create(parent, clickListener)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}