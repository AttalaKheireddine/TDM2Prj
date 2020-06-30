package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDao {
    @Query("SELECT * FROM country")
    fun getAll(): List<Country>

    @Query("SELECT * FROM country WHERE name = (:nameValue)")
    fun loadByName(nameValue:String): List<Country>

    @Insert
    fun insert(countries :Country?)

    @Delete
    fun delete(country: Country)
}