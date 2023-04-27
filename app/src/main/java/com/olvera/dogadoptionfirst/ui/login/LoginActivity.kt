package com.olvera.dogadoptionfirst.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.olvera.dogadoptionfirst.NavigationActivity
import com.olvera.dogadoptionfirst.databinding.ActivityLoginBinding
import com.olvera.dogadoptionfirst.ui.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        binding.signUp.setOnClickListener {
            // Navigate to sign up screen
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }

}