package com.example.thetdmproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country (
    @PrimaryKey(autoGenerate = false) val name: String,
    @ColumnInfo(name = "desc") val description : String,
    @ColumnInfo(name = "surface") val surface : Int,
    @ColumnInfo(name = "population") val population : Int,

    //next are file paths
    @ColumnInfo(name = "flag") val flag : String,
    @ColumnInfo(name = "anthem") val anthem : String
)