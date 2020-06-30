package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RessourceCategoryDao
{
    @Query("SELECT * FROM ressourcecategory")
    fun getAll(): List<RessourceCategory>

    @Query("SELECT * FROM ressourcecategory WHERE name = (:nameValue)")
    fun loadByName(nameValue:String): List<RessourceCategory>

    @Insert
    fun insert(ressourceCatg :RessourceCategory)

    @Delete
    fun delete(country: RessourceCategory)
}