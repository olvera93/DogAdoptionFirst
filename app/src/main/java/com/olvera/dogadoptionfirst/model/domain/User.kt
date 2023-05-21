package com.olvera.dogadoptionfirst.model.domain

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    val userName: String? = null,
    val userEmail: String? = null,
    val userPhone: String? = null,
    val userPassword: String? = null,
    //val userAddress: String,
    //val userCity: String,
    //val profilePhoto: String
    @Embedded
    val dog: Dog ?= null

)
