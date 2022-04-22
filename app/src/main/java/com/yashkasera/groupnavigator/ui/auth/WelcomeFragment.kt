package com.yashkasera.groupnavigator.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yashkasera.groupnavigator.databinding.FragmentWelcomeBinding

/**
 * @author yashkasera
 * Created 17/04/22 at 2:49 PM
 */
class WelcomeFragment : Fragment() {
    private val binding: FragmentWelcomeBinding by lazy {
        FragmentWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.start.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToSignInFragment())
        }
    }
}