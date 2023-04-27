package com.olvera.dogadoptionfirst.ui.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.olvera.dogadoptionfirst.R.string as AppText
import com.olvera.dogadoptionfirst.databinding.ActivitySignUpBinding
import com.olvera.dogadoptionfirst.model.domain.User
import com.olvera.dogadoptionfirst.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signUp()
    }

    private fun signUp() {

        binding.apply {

            emailText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    emailEt.error = null
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (!viewModel.onCheckEmail(emailText.text.toString())) {
                        emailEt.error = getString(AppText.email_error)
                        return
                    } else {
                        viewModel.onUserEmailChange(s.toString())
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })

            passwordText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    passwordEt.error = null
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!viewModel.onCheckPassword(passwordText.text.toString())) {
                        passwordEt.error = getString(AppText.password_error)
                        return
                    } else {
                        viewModel.onUserPasswordChange(p0.toString())
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}
            })

            confirmPasswordText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    confirmPasswordEt.error = null
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!viewModel.onCheckRepeatPassword(
                            passwordText.text.toString(),
                            confirmPasswordText.text.toString()
                        )
                    ) {
                        confirmPasswordEt.error = getString(AppText.password_match_error)

                        return
                    } else {
                        viewModel.onRepeatPasswordChange(p0.toString())
                    }
                }

                override fun afterTextChanged(p0: Editable?) {}

            })

            signUpBtn.setOnClickListener {
                if (viewModel.getUser(emailText.text.toString()) > 0) {
                    Toast.makeText(this@SignUpActivity, "ya existe", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else {
                    val user = User(
                        userName = usernameText.text.toString(),
                        userEmail = emailText.text.toString(),
                        userPhone = phoneText.text.toString(),
                        userPassword = passwordText.text.toString()
                    )
                    viewModel.addUser(user)
                    Toast.makeText(this@SignUpActivity, "usuario creado", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }


        }
    }

}