package com.zenika.common.data

import android.content.Context
import androidx.room.Room
import com.zenika.common.data.database.ZDatabase
import com.zenika.common.data.database.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

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
