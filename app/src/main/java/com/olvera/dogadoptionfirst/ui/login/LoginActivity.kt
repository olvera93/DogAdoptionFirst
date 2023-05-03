package com.olvera.dogadoptionfirst.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.olvera.dogadoptionfirst.NavigationActivity
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.config.AppPrefs
import com.olvera.dogadoptionfirst.databinding.ActivityLoginBinding
import com.olvera.dogadoptionfirst.ui.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setup()

    }

    private fun setup() {

        binding.apply {
            emailText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emailEt.error = null
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!viewModel.onCheckEmail(emailText.text.toString())) {
                        emailEt.error = getString(R.string.email_error)
                        return
                    } else {
                        viewModel.onEmailChanged(p0.toString())
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })

            passwordText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    passwordEt.error = null
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!viewModel.onCheckPassword(passwordText.text.toString())) {
                        passwordEt.error = getString(R.string.password_error)
                        return
                    } else {
                        viewModel.onPasswordChanged(p0.toString())
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })

            loginBtn.setOnClickListener {
                if (viewModel.emailIsEmpty(emailText.text.toString())) {
                    emailEt.error = getString(R.string.empty_email)
                    return@setOnClickListener
                } else if (viewModel.passwordIsEmpty(passwordText.text.toString())) {
                    passwordEt.error = getString(R.string.empty_password)
                    return@setOnClickListener
                }

                viewModel.getUserByEmailAndPassword(
                    emailText.text.toString(),
                    passwordText.text.toString()
                ) { userExist ->
                    if (!userExist) {
                        Toast.makeText(
                            this@LoginActivity,
                            getText(R.string.user_not_exists),
                            Toast.LENGTH_SHORT
                        ).show()
                        return@getUserByEmailAndPassword
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            getText(R.string.suscessful_login),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        val intent = Intent(this@LoginActivity, NavigationActivity::class.java)
                        startActivity(intent)
                        AppPrefs(this@LoginActivity).setEmail(emailText.text.toString())
                        finish()
                    }
                }
            }

            signUp.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}