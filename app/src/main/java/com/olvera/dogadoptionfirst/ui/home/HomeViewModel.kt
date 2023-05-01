package com.olvera.dogadoptionfirst.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.olvera.dogadoptionfirst.model.domain.Dog

class HomeViewModel : ViewModel() {

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
}