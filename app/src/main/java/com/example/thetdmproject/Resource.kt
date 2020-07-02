package com.example.thetdmproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Country::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("country_name"),
        onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = RessourceCategory::class,
            parentColumns = arrayOf("resname"),
            childColumns = arrayOf("ressource_name"),
            onDelete = ForeignKey.CASCADE)
))
data class Resource(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "country_name") val countryName: String,
    @ColumnInfo(name = "ressource_name") val ressourceName: String,
    @ColumnInfo(name="amount") val amount: Double


)