package com.example.thetdmproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class RessourceCategory(
    @PrimaryKey(autoGenerate = false) val resname: String,
    @ColumnInfo(name="unit") val unit :String
)