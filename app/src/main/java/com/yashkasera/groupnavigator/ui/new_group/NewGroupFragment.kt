package com.yashkasera.groupnavigator.ui.new_group

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.yashkasera.groupnavigator.databinding.FragmentNewGroupBinding
import com.yashkasera.groupnavigator.repository.model.Member
import com.yashkasera.groupnavigator.util.ItemClickListener

/**
 * @author yashkasera
 * Created 21/04/22 at 12:39 AM
 */
class NewGroupFragment : Fragment() {
    private val binding by lazy {
        FragmentNewGroupBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[NewGroupViewModel::class.java]
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
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.memberAdapter.setClickListener(object: ItemClickListener<Member> {
            override fun onItemClick(v: View?, item: Member) {
                Log.d("NewGroupFragment.kt", "YASH => onItemClick: $item")
            }
        })
        binding.back.setOnClickListener { findNavController().navigateUp() }
    }
}