package com.olvera.dogadoptionfirst.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepository
import com.olvera.dogadoptionfirst.model.domain.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dogAdoptionRepository: DogAdoptionRepository
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun getUser(email: String) {
        viewModelScope.launch {
            try {
                val user = dogAdoptionRepository.getUser(email)
                _user.value = user
            } catch (e: Exception) {
                null
            }
        }
    }


}