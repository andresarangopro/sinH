package com.example.logogenia.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.domain.databasemanager.MaterialDatabase
import com.example.domain.databasemanager.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val databaseName = "material_db"
    @Provides
    fun provideContext(
        app: Application
    ): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideMovieDatabase(
        @ApplicationContext app: Context
    ): MaterialDatabase = Room.databaseBuilder(
        app,
        MaterialDatabase::class.java,
        databaseName
    ).build()

    @Provides
    @Singleton
    fun provideWordDetailDao(db: MaterialDatabase): WordDao = db.wordDao()

}