package com.abhiram.vignjyaan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materials")
class MaterialsList (
    @ColumnInfo(name = "sub") var sub: String,
    @ColumnInfo(name = "type") var type : String,
    @ColumnInfo(name = "sem") val sem: Int,
    @ColumnInfo(name = "module") var mod : Int,
    @ColumnInfo(name = "link") var link : String,
    @PrimaryKey(autoGenerate = false) val name: String
    )
