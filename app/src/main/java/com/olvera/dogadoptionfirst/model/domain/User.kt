package com.olvera.dogadoptionfirst.model.domain

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    val userName: String,
    val userEmail: String,
    val userPhone: String,
    val userPassword: String,
    //val userAddress: String,
    //val userCity: String,
    //val profilePhoto: String
    @Embedded
    val dog: Dog ?= null

)
