package com.olvera.dogadoptionfirst.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olvera.dogadoptionfirst.model.domain.Dog

@Database(entities = [Dog::class], version = 1)
abstract class DogDatabase: RoomDatabase() {

    abstract fun dogDao(): DogDao
}