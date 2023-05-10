package com.olvera.dogadoptionfirst.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs")
data class Dog(
    @PrimaryKey(autoGenerate = true)
    val dogId: Int = 0,
    val dogName: String,
    val imageUrl : String,
    val dogAge: String
)
