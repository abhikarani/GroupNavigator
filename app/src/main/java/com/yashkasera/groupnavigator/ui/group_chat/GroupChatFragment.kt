package com.yashkasera.groupnavigator.ui.group_chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yashkasera.groupnavigator.databinding.FragmentGroupChatBinding

/**
 * @author yashkasera
 * Created 21/04/22 at 12:46 AM
 */
class GroupChatFragment : Fragment() {
    private val binding by lazy {
        FragmentGroupChatBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[GroupChatViewModel::class.java]
    }
    private val args by lazy { GroupChatFragmentArgs.fromBundle(requireArguments()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.group = args.group
        binding.viewModel = viewModel
        binding.back.setOnClickListener { findNavController().navigateUp() }
    }
}