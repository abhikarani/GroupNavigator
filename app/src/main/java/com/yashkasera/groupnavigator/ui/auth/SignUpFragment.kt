package com.yashkasera.groupnavigator.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yashkasera.groupnavigator.databinding.FragmentSignUpBinding

/**
 * @author yashkasera
 * Created 17/04/22 at 2:56 PM
 */
class SignUpFragment : Fragment() {
    private val binding: FragmentSignUpBinding by lazy {
        FragmentSignUpBinding.inflate(layoutInflater)
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
        with(binding) {
            signIn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}