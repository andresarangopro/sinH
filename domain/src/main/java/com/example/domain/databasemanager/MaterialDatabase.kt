package com.example.domain.databasemanager

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.databasemanager.localDatabaseEntities.WordEntity

@Database(entities = [WordEntity::class], version = 1)
abstract class MaterialDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}