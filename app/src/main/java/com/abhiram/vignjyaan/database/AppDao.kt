package com.abhiram.vignjyaan.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.abhiram.vignjyaan.adapters.File


@Dao
interface AppDao {

    @Query("SELECT * FROM materials ORDER BY sub ASC")
    fun getAll(): List<MaterialsList>

    @Query("SELECT * FROM faculties WHERE type LIKE :type")
    suspend fun getFac(type:String) : MutableList<Faculties>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(file: MaterialsList )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSub(sub: Subjects )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFaculty(faculty: Faculties )
//    @Query("INSERT INTO subjects VALUES(:sem, :name, :code, NULL)")
//    fun addSub(sem : Int,name : String,code : String )
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun add(sub : Subjects)

}
