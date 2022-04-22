package com.yashkasera.groupnavigator.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yashkasera.groupnavigator.AuthActivity
import com.yashkasera.groupnavigator.MainActivity
import com.yashkasera.groupnavigator.R
import com.yashkasera.groupnavigator.databinding.FragmentHomeBinding
import com.yashkasera.groupnavigator.repository.model.Group
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 17/04/22 at 3:20 PM
 */
class HomeFragment : Fragment() {
    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.lifecycleOwner = this
        binding.handler = this
        binding.viewModel = viewModel
        viewModel.groupAdapter.setClickListener(object : ItemClickListener<Group> {
            override fun onItemClick(v: View?, item: Group) {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToGroupChatFragment(
                        item
                    )
                )
            }

        })
        binding.options.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), it)
            popupMenu.inflate(R.menu.menu_home)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_logout -> {
                        MainActivity.auth.signOut()
                        AuthActivity.start(requireContext())
                        requireActivity().finish()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
    }

    fun openNewGroupFragment(view: View) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNewGroupFragment())
    }
}