package com.yashkasera.groupnavigator.ui.home

import androidx.lifecycle.ViewModel
import com.yashkasera.groupnavigator.repository.model.Group
import com.yashkasera.groupnavigator.ui.adapter.GroupAdapter

/**
 * @author yashkasera
 * Created 21/04/22 at 12:19 AM
 */
class HomeViewModel : ViewModel() {
    private val groups = listOf<Group>(
        Group("1", "Group 1", emptyList()),
        Group("2", "Group 2", emptyList()),
        Group("3", "Group 3", emptyList()),
        Group("4", "Group 4", emptyList()),
        Group("5", "Group 5", emptyList()),
        Group("6", "Group 6", emptyList()),
    )
    val groupAdapter by lazy { GroupAdapter() }

    init {
        groupAdapter.submitList(groups)
    }
}