package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryImgDao {
    @Query("SELECT * FROM countryimg")
    fun getAll(): List<CountryImg>

    @Query("SELECT * FROM countryimg WHERE id = (:id)")
    fun loadById(id:Int): List<CountryImg>

    @Query("SELECT * FROM countryimg e " +
            "JOIN country c " +
            "ON c.name =e.country_name "+
            "WHERE name = (:countryName) ")
    fun loadAllByCountry(countryName:String): List<CountryImg>

    @Insert
    fun Insert(che: CountryImg)

    @Delete
    fun delete(che: CountryImg)
}