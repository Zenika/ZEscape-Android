package com.zenika.di

import android.content.Context
import androidx.room.Room
import com.zenika.data.database.ZDatabase
import com.zenika.data.database.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): ZDatabase {
        return Room.databaseBuilder(
            context,
            ZDatabase::class.java,
            "zdatabase.db"
        ).build()
    }

    @Provides
    fun provideItemDao(
        database: ZDatabase
    ): ItemDao {
        return database.itemDao
    }
}
