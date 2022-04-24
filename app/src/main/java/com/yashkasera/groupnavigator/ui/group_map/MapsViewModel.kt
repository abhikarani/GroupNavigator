package com.yashkasera.groupnavigator.ui.group_map

import androidx.lifecycle.ViewModel
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.ui.adapter.MemberAdapter

/**
 * @author yashkasera
 * Created 23/04/22 at 2:26 AM
 */
class MapsViewModel : ViewModel() {
    val memberAdapter by lazy {
        MemberAdapter()
    }

    val members = listOf<Member>(
        Member("1", "Yash", "+919648111905", "yashkasera@icloud.com", "Kanpur"),
        Member("2", "Abhi", "+919648111905", "yashkasera@icloud.com", "Kanpur"),
        Member("3", "Aki", "+919648111905", "yashkasera@icloud.com", "Kanpur"),
    )

    init {
        memberAdapter.submitList(members)
    }
}