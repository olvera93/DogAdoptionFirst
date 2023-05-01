package com.olvera.dogadoptionfirst.ui.login

import com.olvera.dogadoptionfirst.DogAdoptionViewModel
import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepository
import com.olvera.dogadoptionfirst.model.domain.LoginUiState
import com.olvera.dogadoptionfirst.util.isEmptyTextEdit
import com.olvera.dogadoptionfirst.util.isValidEmail
import com.olvera.dogadoptionfirst.util.isValidPassword
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dogAdoptionRepository: DogAdoptionRepository
) : DogAdoptionViewModel() {

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

    fun getUserByEmailAndPassword(email: String, password: String, callback: (Boolean) -> Unit) {
        launchCatching {
            val user = dogAdoptionRepository.getUserByEmailAndPassword(email, password)
            callback(user != null)
        }
    }


    fun emailIsEmpty(email: String): Boolean {
        return email.isEmptyTextEdit()
    }

    fun passwordIsEmpty(password: String): Boolean {
        return password.isEmptyTextEdit()
    }

    fun onCheckEmail(email: String): Boolean {
        return email.isValidEmail()
    }

    fun onCheckPassword(password: String): Boolean {
        return password.isValidPassword()
    }

}