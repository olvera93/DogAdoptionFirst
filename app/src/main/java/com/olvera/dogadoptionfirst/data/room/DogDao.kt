package com.olvera.dogadoptionfirst.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.olvera.dogadoptionfirst.model.domain.Dog
import androidx.room.Query

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.NONE)
    suspend fun insertDog(dog: List<Dog>)

    @Query("SELECT * FROM dogs WHERE dogId = :id")
    suspend fun getDog(id: Int): Dog


}