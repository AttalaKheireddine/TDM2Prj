package com.example.thetdmproject

import android.accounts.AuthenticatorDescription
import androidx.room.*
import java.util.*

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Country::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("country_name"),
        onDelete = ForeignKey.CASCADE)
))
@TypeConverters(DateConverter::class)
data class CountryHistoryEvent (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "date") val date : Date,
    @ColumnInfo(name = "country_name") val name : String,
    @ColumnInfo(name = "description") val description: String
)