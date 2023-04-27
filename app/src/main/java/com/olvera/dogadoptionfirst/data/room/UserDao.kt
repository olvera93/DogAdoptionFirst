package com.olvera.dogadoptionfirst.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olvera.dogadoptionfirst.model.domain.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE userEmail = :email")
    suspend fun getUser(email: String): User

    @Query("SELECT COUNT(*) FROM users WHERE userEmail = :email")
    fun getUserCount(email: String): Int

    @Delete
    suspend fun deleteUser(user: User)
}