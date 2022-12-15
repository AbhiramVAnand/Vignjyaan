package com.abhiram.vignjyaan.database

import androidx.room.*
import com.abhiram.vignjyaan.adapters.File


@Dao
interface AppDao {

    @Query("SELECT * FROM materials ORDER BY sub ASC")
    fun getAll(): List<MaterialsList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(file: MaterialsList )

    @Query("DELETE FROM materials")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSub(sub: Subjects )

//    @Query("INSERT INTO subjects VALUES(:sem, :name, :code, NULL)")
//    fun addSub(sem : Int,name : String,code : String )
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun add(sub : Subjects)

}