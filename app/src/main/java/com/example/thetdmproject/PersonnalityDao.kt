package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonnalityDao {
    @Query("SELECT * FROM personnality")
    fun getAll(): List<Personnality>

    @Query("SELECT * FROM personnality WHERE id = (:id)")
    fun loadById(id:Int): List<Personnality>

    @Query("SELECT * FROM personnality e " +
            "JOIN country c " +
            "ON c.name =e.country_name " +
            "WHERE name = (:countryName)")
    fun loadAllByCountry(countryName:String): List<Personnality>

    @Insert
    fun Insert(che: Personnality)

    @Delete
    fun delete(che: Personnality)
}