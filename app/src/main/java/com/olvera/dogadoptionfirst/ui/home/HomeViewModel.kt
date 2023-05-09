package com.olvera.dogadoptionfirst.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.olvera.dogadoptionfirst.DogAdoptionViewModel
import com.olvera.dogadoptionfirst.R
import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepository
import com.olvera.dogadoptionfirst.model.domain.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dogAdoptionRepository: DogAdoptionRepository,
    @ApplicationContext private val appContext: Context

) : DogAdoptionViewModel() {


    private val _dogList = MutableLiveData<List<Dog>>().apply {
        value =
            listOf(
                Dog(
                    0,
                    "Canelo",
                    "https://purepng.com/public/uploads/large/purepng.com-dog-pngdogdoggycutehoundblack-snoutgerman-shepperdlooking-to-camera-451520332369fzowk.png",
                    appContext.resources.getString(R.string.dog_age, 6)
                ),
                Dog(
                    1,
                    "Firulais",
                    "https://static.vecteezy.com/system/resources/previews/018/871/732/original/cute-and-happy-dog-png.png",
                    appContext.resources.getString(R.string.dog_age, 12)
                ),
                Dog(
                    2,
                    "Doggy",
                    "https://assets.stickpng.com/images/580b57fbd9996e24bc43bbdf.png",
                    appContext.resources.getString(R.string.dog_age, 10)
                ),
                Dog(
                    3,
                    "Pancho",
                    "https://static.vecteezy.com/system/resources/previews/018/871/734/original/cute-and-happy-dog-png.png",
                    appContext.resources.getString(R.string.dog_age, 4)
                ),

                Dog(
                    4,
                    "Killer",
                    "https://pngfre.com/wp-content/uploads/1653719927749-961x1024.png",
                    appContext.resources.getString(R.string.dog_age, 8)
                ),

                )
    }
    val dogList: LiveData<List<Dog>> = _dogList

    init {
        insertDog(
            dogList.value!!
        )
    }

    private fun insertDog(dog: List<Dog>) {
        launchCatching {
            dogAdoptionRepository.insertDog(dog)
        }
    }

    fun addDogToUser(email: String, dogId: Int, dogName: String, dogImage: String, age: String) {
        launchCatching {
            dogAdoptionRepository.addDogToUser(email, dogId, dogName, dogImage, age)
        }
    }
}