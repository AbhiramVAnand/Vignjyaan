package com.abhiram.vignjyaan.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
class Subjects (
    @ColumnInfo(name = "sem") val sem : Int,
    @ColumnInfo(name = "subName") val subName : String,
    @ColumnInfo(name = "subCode") val subCode : String,
    @PrimaryKey(autoGenerate = false) val id : Int
)