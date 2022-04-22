package com.yashkasera.groupnavigator.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.yashkasera.groupnavigator.MainActivity
import com.yashkasera.groupnavigator.databinding.FragmentSignInBinding

/**
 * @author yashkasera
 * Created 17/04/22 at 2:56 PM
 */
class SignInFragment : Fragment() {
    private val binding: FragmentSignInBinding by lazy {
        FragmentSignInBinding.inflate(layoutInflater)
    }

    private val auth by lazy {
        FirebaseAuth.getInstance()
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
            back.setOnClickListener {
                findNavController().navigateUp()
            }
            signUp.setOnClickListener {
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
            }
            login.setOnClickListener {
                if (email.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
                    Snackbar.make(root, "Please enter email and password", Snackbar.LENGTH_SHORT)
                        .show()
                } else {
                    auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                MainActivity.start(requireActivity()).also {
                                    requireActivity().finish()
                                }
                            } else {
                                it.exception?.printStackTrace()
                                Snackbar.make(root, "Login failed", Snackbar.LENGTH_SHORT).show()
                            }
                        }
                }
            }
        }
    }
}