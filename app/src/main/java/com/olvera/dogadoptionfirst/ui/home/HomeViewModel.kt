package com.olvera.dogadoptionfirst.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.olvera.dogadoptionfirst.DogAdoptionViewModel
import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepository
import com.olvera.dogadoptionfirst.model.domain.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dogAdoptionRepository: DogAdoptionRepository
) : DogAdoptionViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>().apply {
        value =
            listOf(
                Dog(
                    0,
                    "Firulais",
                    "https://paradepets.com/.image/t_share/MTkxMzY1Nzg4NjczMzIwNTQ2/cutest-dog-breeds-jpg.jpg"
                ),
                Dog(
                    1,
                    "Firulais",
                    "https://paradepets.com/.image/t_share/MTkxMzY1Nzg4NjczMzIwNTQ2/cutest-dog-breeds-jpg.jpg"
                ),
                Dog(
                    2,
                    "Firulais",
                    "https://paradepets.com/.image/t_share/MTkxMzY1Nzg4NjczMzIwNTQ2/cutest-dog-breeds-jpg.jpg"
                ),
                Dog(
                    3,
                    "Firulais",
                    "https://paradepets.com/.image/t_share/MTkxMzY1Nzg4NjczMzIwNTQ2/cutest-dog-breeds-jpg.jpg"
                ),

                Dog(
                    4,
                    "Firulais",
                    "https://paradepets.com/.image/t_share/MTkxMzY1Nzg4NjczMzIwNTQ2/cutest-dog-breeds-jpg.jpg"
                ),

            )
    }
    val dogList: LiveData<List<Dog>> = _dogList


    fun insertDog(dog: Dog) {
        launchCatching {
            dogAdoptionRepository.insertDog(dog)
        }
    }

    fun addDogToUser(email: String, dogId: Int, dogName: String, dogImage: String) {
        launchCatching {
            dogAdoptionRepository.addDogToUser(email, dogId, dogName, dogImage)
        }
    }
}