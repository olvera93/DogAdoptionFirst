package com.olvera.dogadoptionfirst.data.room

import com.olvera.dogadoptionfirst.model.domain.User
import javax.inject.Inject


interface UserRepository {

    // Room
    suspend fun insertUser(user: User)
    suspend fun getUser(email: String): User
    suspend fun getUserCount(email: String): Int

}

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
): UserRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user)
    override suspend fun getUser(email: String): User = userDao.getUser(email)
    override suspend fun getUserCount(email: String): Int = userDao.getUserCount(email)
}

