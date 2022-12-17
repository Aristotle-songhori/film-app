package com.aristotele.film.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aristotele.film.db.MovieEntity
import com.aristotele.film.db.MoviesDao

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MoviesDao
}