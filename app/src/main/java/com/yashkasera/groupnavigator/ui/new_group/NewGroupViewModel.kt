package com.yashkasera.groupnavigator.ui.new_group

import androidx.lifecycle.ViewModel
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.ui.adapter.MemberAdapter

/**
 * @author yashkasera
 * Created 21/04/22 at 12:42 AM
 */
class NewGroupViewModel : ViewModel() {
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