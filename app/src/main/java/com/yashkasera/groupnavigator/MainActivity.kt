package com.yashkasera.groupnavigator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.yashkasera.groupnavigator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object {
        val auth by lazy {
            FirebaseAuth.getInstance()
        }

        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth.addAuthStateListener { auth ->
            if (auth.currentUser == null) {
                AuthActivity.start(this)
                finish()
            }
        }
    }
}