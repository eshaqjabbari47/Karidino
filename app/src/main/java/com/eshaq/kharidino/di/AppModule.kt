package com.eshaq.kharidino.di

import android.content.Context
import androidx.room.Room
import com.eshaq.kharidino.model.repository.ItemRepository
import com.eshaq.kharidino.model.room.AppDataBase
import com.eshaq.kharidino.model.room.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDataBase = Room.databaseBuilder(context,AppDataBase::class.java,"kharidino_db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideItemDao(appDataBase: AppDataBase):ItemDao=appDataBase.ItemDao()

    @Provides
    fun provideItemRepository(appDataBase: AppDataBase):ItemRepository=ItemRepository(ItemDao)
}