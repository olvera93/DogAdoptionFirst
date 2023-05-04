package com.olvera.dogadoptionfirst.data.remote

import com.olvera.dogadoptionfirst.data.room.DogDao
import com.olvera.dogadoptionfirst.data.room.UserDao
import com.olvera.dogadoptionfirst.model.domain.Dog
import com.olvera.dogadoptionfirst.model.domain.User
import javax.inject.Inject


interface DogAdoptionRepository{

    // Room
    suspend fun insertUser(user: User)
    suspend fun getUser(email: String): User
    suspend fun getUserCount(email: String): Int
    suspend fun getUserByEmailAndPassword(email: String, password: String): User
    suspend fun insertDog(dog: Dog)

    suspend fun addDogToUser(email: String, dogId: Int, dogName: String, dogImage: String)

}

class DogAdoptionRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val dogDao: DogDao
) : DogAdoptionRepository {
    override suspend fun insertUser(user: User) = userDao.insertUser(user)
    override suspend fun getUser(email: String): User = userDao.getUser(email)
    override suspend fun getUserCount(email: String): Int = userDao.getUserCount(email)
    override suspend fun getUserByEmailAndPassword(email: String, password: String): User =
        userDao.getUserByEmailAndPassword(email, password)

    override suspend fun insertDog(dog: Dog) = dogDao.insertDog(dog)
    override suspend fun addDogToUser(email: String, dogId: Int, dogName: String, dogImage: String) = userDao.addDogToUser(email, dogId, dogName, dogImage)
}

