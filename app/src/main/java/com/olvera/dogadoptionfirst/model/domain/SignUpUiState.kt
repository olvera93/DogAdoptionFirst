package com.olvera.dogadoptionfirst.model.domain

data class SignUpUiState(
    var userName: String = "",
    var userEmail: String = "",
    var userPhone: String = "",
    var userPassword: String = "",
    var repeatPassword: String = ""
)
