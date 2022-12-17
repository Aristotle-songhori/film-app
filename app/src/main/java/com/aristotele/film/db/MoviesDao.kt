package com.aristotele.film.db


import androidx.room.*
import com.aristotele.film.db.MovieEntity
import com.aristotele.film.utils.Constants

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(entity: MovieEntity)

    @Delete
    suspend fun deleteMovie(entity: MovieEntity)

    @Query("SELECT * FROM ${Constants.MOVIES_TABLE}")
    fun getAllMovies(): MutableList<MovieEntity>

    /**
     * کنترل وجود 1 آیدی در دیتابیس و بولین برمیگردونه]
     */
    @Query("SELECT EXISTS (SELECT 1 FROM ${Constants.MOVIES_TABLE} WHERE id = :movieId)")
    suspend fun existsMovie(movieId: Int): Boolean
}