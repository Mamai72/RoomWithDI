package com.ib.roomwithdi.di

import android.content.Context
import androidx.room.Room
import com.ib.roomwithdi.data.UserDao
import com.ib.roomwithdi.data.UserDatabase
import com.ib.roomwithdi.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

@Provides
    fun provideRepository(userDao: UserDao): Repository {
        return Repository(userDao)
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : UserDatabase{
      return  Room.databaseBuilder(
          context.applicationContext,
          UserDatabase::class.java,
          "user_table"
      ).build()
    }

    @Provides
    fun provideDao(userDatabase: UserDatabase): UserDao{
        return userDatabase.userDao()
    }
}