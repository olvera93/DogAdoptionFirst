package com.olvera.dogadoptionfirst.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olvera.dogadoptionfirst.model.domain.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}