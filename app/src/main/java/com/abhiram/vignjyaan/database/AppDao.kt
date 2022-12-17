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

    @Query("SELECT * FROM subjects WHERE sem LIKE :sem")
    suspend fun getSub(sem:Int) : MutableList<Subjects>

    @Query("SELECT * FROM materials WHERE type LIKE :type ORDER BY name ASC")
    suspend fun getFile(type:String) : MutableList<MaterialsList>

    @Query("SELECT * FROM materials WHERE type LIKE :type AND sub LIKE :sub ORDER BY name ASC")
    suspend fun getFiles(type:String,sub:String) : MutableList<MaterialsList>

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
