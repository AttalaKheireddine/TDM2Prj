package com.example.thetdmproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryHistoryEventDao {
    @Query("SELECT * FROM countryhistoryevent")
    fun getAll(): List<CountryHistoryEvent>

    @Query("SELECT * FROM countryhistoryevent WHERE id = (:id)")
    fun loadById(id:Int): List<CountryHistoryEvent>

    @Query("SELECT * FROM countryhistoryevent e " +
            "JOIN country c " +
            "ON c.name =e.country_name " +
            "WHERE name = (:countryName)")
    fun loadAllByCountry(countryName:String): List<CountryHistoryEvent>

    @Insert
    fun insert(che: CountryHistoryEvent)

    @Delete
    fun delete(che: CountryHistoryEvent)
}