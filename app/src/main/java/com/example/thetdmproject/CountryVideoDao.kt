package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryVideoDao {
    @Query("SELECT * FROM countryvideo")
    fun getAll(): List<CountryVideo>

    @Query("SELECT * FROM countryvideo WHERE id = (:id)")
    fun loadById(id:Int): List<CountryVideo>

    @Query("SELECT * FROM countryvideo e " +
            "JOIN country c " +
            "ON c.name =e.country_name " +
            "WHERE name = (:countryName)")
    fun loadAllByCountry(countryName:String): List<CountryVideo>

    @Insert
    fun Insert(che: CountryVideo)

    @Delete
    fun delete(che: CountryVideo)
}