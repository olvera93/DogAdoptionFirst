package com.olvera.dogadoptionfirst.di

import android.content.Context
import androidx.room.Room
import com.olvera.dogadoptionfirst.data.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDatabaseModule {

    @Provides
    fun provideUserDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        "user_database"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao()

}