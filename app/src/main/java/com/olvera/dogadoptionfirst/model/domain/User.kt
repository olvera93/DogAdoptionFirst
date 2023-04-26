package com.olvera.dogadoptionfirst.model.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "users")
@Parcelize
data class User(

    @PrimaryKey()
    val userId: Int,

    val userName: String,
    val userEmail: String,
    val userPassword: String,
    val userPhone: String,
    val userAddress: String,
    val userCity: String,
    val profilePhoto: String
) : Parcelable
