package com.example.thetdmproject


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RessourceDao
{
    @Query("SELECT * FROM resource")
    fun getAll(): List<Resource>

    @Query("SELECT * FROM resource WHERE id = (:id)")
    fun loadById(id:Int): List<Resource>

    @Query("SELECT * FROM resource e " +
            "JOIN country c " +
            "ON c.name =e.country_name " +
            "WHERE name = (:countryName)")
    fun loadAllByCountry(countryName:String): List<Resource>

    @Query("SELECT * FROM resource e " +
            "JOIN ressourcecategory c " +
            "ON c.resname =e.ressource_name " +
            "WHERE resname = (:categoryName)")
    fun loadAllByRessourceCategory(categoryName:String): List<Resource>

    @Insert
    fun insert(che: Resource)

    @Delete
    fun delete(che: Resource)
}