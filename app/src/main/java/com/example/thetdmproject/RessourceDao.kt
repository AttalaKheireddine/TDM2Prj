package com.example.thetdmproject

import android.content.res.Resources
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RessourceDao
{
    @Query("SELECT * FROM ressource")
    fun getAll(): List<Ressource>

    @Query("SELECT * FROM ressource WHERE id = (:id)")
    fun loadById(id:Int): List<Ressource>

    @Query("SELECT * FROM ressource e " +
            "JOIN country c " +
            "ON c.name =e.country_name " +
            "WHERE name = (:countryName)")
    fun loadAllByCountry(countryName:String): List<Ressource>

    @Query("SELECT * FROM ressource e " +
            "JOIN ressourcecategory c " +
            "ON c.name =e.ressource_name " +
            "WHERE name = (:categoryName)")
    fun loadAllByRessourceCategory(categoryName:String): List<Ressource>

    @Insert
    fun Insert(che: Ressource)

    @Delete
    fun delete(che: Ressource)
}