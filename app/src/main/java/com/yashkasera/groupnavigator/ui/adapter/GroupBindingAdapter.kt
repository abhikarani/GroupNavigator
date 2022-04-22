package com.yashkasera.groupnavigator.ui.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author yashkasera
 * Created 21/04/22 at 12:28 AM
 */
@BindingAdapter("groupAdapter")
fun setGroupAdapter(
    recyclerView: RecyclerView,
    adapter: GroupAdapter
) {
    recyclerView.adapter = adapter
}

@BindingAdapter("memberAdapter")
fun setMemberAdapter(
    recyclerView: RecyclerView,
    adapter: MemberAdapter
) {
    recyclerView.adapter = adapter
}

@BindingAdapter("messageAdapter")
fun setMessageAdapter(
    recyclerView: RecyclerView,
    adapter: MessageAdapter
) {
    recyclerView.adapter = adapter
}