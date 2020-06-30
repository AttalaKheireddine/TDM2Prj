package com.example.thetdmproject
import androidx.room.*
import com.example.thetdmproject.Country
import com.example.thetdmproject.DateConverter
import java.util.*

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = Country::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("country_name"),
        onDelete = ForeignKey.CASCADE)
))
@TypeConverters(DateConverter::class)
data class Personnality(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "country_name") val countryName: String,
    @ColumnInfo(name = "birth_date") val Bdate : Date,
    @ColumnInfo(name = "death_date") val Ddate : Date?,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "photo") val photo : String
)