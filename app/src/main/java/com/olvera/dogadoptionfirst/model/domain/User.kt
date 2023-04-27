package com.olvera.dogadoptionfirst.model.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    val userName: String,
    val userEmail: String,
    val userPhone: String,
    val userPassword: String
    //val userAddress: String,
    //val userCity: String,
    //val profilePhoto: String
)
