package com.olvera.dogadoptionfirst.di

import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepository
import com.olvera.dogadoptionfirst.data.remote.DogAdoptionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DogAdoptionRepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: DogAdoptionRepositoryImpl
    ): DogAdoptionRepository
}