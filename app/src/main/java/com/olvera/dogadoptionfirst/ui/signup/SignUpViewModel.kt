package com.olvera.dogadoptionfirst.ui.signup


import android.util.Log
import com.olvera.dogadoptionfirst.DogAdoptionViewModel
import com.olvera.dogadoptionfirst.data.room.UserRepository
import com.olvera.dogadoptionfirst.model.domain.SignUpUiState
import com.olvera.dogadoptionfirst.model.domain.User
import com.olvera.dogadoptionfirst.util.isValidEmail
import com.olvera.dogadoptionfirst.util.isValidPassword
import com.olvera.dogadoptionfirst.util.passwordMatches
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : DogAdoptionViewModel() {


    var uiState = SignUpUiState()
        private set

    private val userName
        get() = uiState.userName

    private val userEmail
        get() = uiState.userEmail

    private val userPhone
        get() = uiState.userPhone

    private val userPassword
        get() = uiState.userPassword

    fun onUserNameChange(newValue: String) {
        uiState = uiState.copy(userName = newValue)
    }

    fun onUserEmailChange(newValue: String) {
        uiState = uiState.copy(userEmail = newValue)
    }

    fun onUserPhoneChange(newValue: String) {
        uiState = uiState.copy(userPhone = newValue)
    }

    fun onUserPasswordChange(newValue: String) {
        uiState = uiState.copy(userPassword = newValue)
    }

    fun onRepeatPasswordChange(newValue: String) {
        uiState = uiState.copy(repeatPassword = newValue)
    }


    fun addUser(user: User) {
        launchCatching {
            userRepository.insertUser(user)
        }
    }

    fun getUser(email: String): Int {
        var userCount = 0
        launchCatching {
            userCount = userRepository.getUserCount(email)
        }
        return userCount

    }


    fun onCheckEmail(email: String): Boolean {
        return email.isValidEmail()
    }

    fun onCheckPassword(password: String): Boolean {
        return password.isValidPassword()
    }

    fun onCheckRepeatPassword(password: String, repeatPassword: String): Boolean {
        return password.passwordMatches(repeatPassword)
    }

}