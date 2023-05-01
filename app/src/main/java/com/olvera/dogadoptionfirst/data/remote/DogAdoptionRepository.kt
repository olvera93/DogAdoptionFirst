package com.olvera.dogadoptionfirst.data.remote

import com.olvera.dogadoptionfirst.data.room.UserDao
import com.olvera.dogadoptionfirst.model.domain.User
import javax.inject.Inject


interface DogAdoptionRepository{

    // Room
    suspend fun insertUser(user: User)
    suspend fun getUser(email: String): User
    suspend fun getUserCount(email: String): Int

    suspend fun getUserByEmailAndPassword(email: String, password: String): User

}

class DogAdoptionRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : DogAdoptionRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user)
    override suspend fun getUser(email: String): User = userDao.getUser(email)
    override suspend fun getUserCount(email: String): Int = userDao.getUserCount(email)
    override suspend fun getUserByEmailAndPassword(email: String, password: String): User =
        userDao.getUserByEmailAndPassword(email, password)
}

