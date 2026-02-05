package com.example.pokeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokeapp.data.local.type.dao.TypeDao
import com.example.pokeapp.data.local.type.entity.TypeEntity

@Database(
    entities = [
        TypeEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun typeDao(): TypeDao
}