package com.example.proyecto.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1
const val TABLE_PRODUCTS = "productos"
const val DATABASE_NAME = "appdata" +
        "base.sqlite"

@Database(entities = [ProductEntity::class],
    version = DATABASE_VERSION
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun priductDao(): PriductDao

}