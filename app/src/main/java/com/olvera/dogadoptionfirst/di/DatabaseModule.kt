package com.olvera.dogadoptionfirst.di

import android.content.Context
import androidx.room.Room
import com.olvera.dogadoptionfirst.data.room.DogDatabase
import com.olvera.dogadoptionfirst.data.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideUserDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        "user_database"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    fun provideDogDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        DogDatabase::class.java,
        "dog_database"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao()

    @Provides
    @Singleton
    fun provideDogDao(dogDatabase: DogDatabase) = dogDatabase.dogDao()

}