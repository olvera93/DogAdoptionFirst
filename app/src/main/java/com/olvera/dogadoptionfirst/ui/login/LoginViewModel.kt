package com.olvera.dogadoptionfirst.ui.login

import androidx.lifecycle.ViewModel
import com.olvera.dogadoptionfirst.model.domain.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var uiState = LoginUiState()
        private set

    private val email
        get() = uiState.email

    private val password
        get() = uiState.password

    fun onEmailChanged(email: String) {
        uiState = uiState.copy(email = email)
    }

    fun onPasswordChanged(password: String) {
        uiState = uiState.copy(password = password)
    }

}