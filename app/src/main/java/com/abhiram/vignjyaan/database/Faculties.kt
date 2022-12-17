package com.abhiram.vignjyaan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculties")
class Faculties (
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "type") val type : String,
    @ColumnInfo(name = "mail") val mail : String,
    @ColumnInfo(name = "designation") val desgn : String,
    @PrimaryKey(autoGenerate = false) val id : Int
)
