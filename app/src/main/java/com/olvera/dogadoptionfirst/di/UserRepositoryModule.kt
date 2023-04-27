package com.olvera.dogadoptionfirst.di

import com.olvera.dogadoptionfirst.data.room.UserRepository
import com.olvera.dogadoptionfirst.data.room.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}