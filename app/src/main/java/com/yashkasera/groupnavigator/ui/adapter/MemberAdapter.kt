package com.yashkasera.groupnavigator.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yashkasera.groupnavigator.databinding.ItemMemberBinding
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 21/04/22 at 12:15 AM
 */
class MemberAdapter : ListAdapter<Member, MemberAdapter.MemberViewHolder>(MemberDiffCallback) {
    private lateinit var clickListener: ItemClickListener<Member>

    class MemberViewHolder(
        private val binding: ItemMemberBinding,
        private val clickListener: ItemClickListener<Member>
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(member: Member) {
            binding.member = member
            binding.root.setOnClickListener { clickListener.onItemClick(item = member) }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                clickListener: ItemClickListener<Member>
            ): MemberViewHolder {
                return MemberViewHolder(
                    ItemMemberBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    clickListener
                )
            }
        }
    }

    fun setClickListener(clickListener: ItemClickListener<Member>) {
        this.clickListener = clickListener
    }

    object MemberDiffCallback : DiffUtil.ItemCallback<Member>() {
        override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemberViewHolder {
        return MemberViewHolder.create(parent, clickListener)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}