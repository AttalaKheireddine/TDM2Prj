package com.example.thetdmproject

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.concurrent.Executors

@Database(entities = [Country::class,CountryHistoryEvent::class,CountryImg::class,CountryVideo::class,
    Personnality::class,RessourceCategory::class,Resource::class], version = 1, exportSchema = false)
abstract class CountriesDB : RoomDatabase() {
    abstract fun countryDao() :CountryDao
    abstract fun countryHistoryEventDao() :CountryHistoryEventDao
    abstract fun countryImgDao() : CountryImgDao
    abstract fun countryVideoDao() : CountryVideoDao
    abstract fun personnalityDao() : PersonnalityDao
    abstract fun ressourceDao() : RessourceDao
    abstract fun ressouceCategDao() : RessourceCategoryDao

    companion object {
        private var INSTANCE: CountriesDB? = null
        @Synchronized
        fun getInstance(context: Context): CountriesDB? {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context): CountriesDB {
            return Room.databaseBuilder(
                context.applicationContext,
                CountriesDB::class.java,
                "my_database"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadScheduledExecutor()
                            .execute(Runnable {
                                intialRessourceCategories()!!.forEach {
                                    getInstance(context)!!.ressouceCategDao().insert(it)
                                }
                                initalCountries()!!.forEach {
                                    getInstance(context)!!.countryDao().insert(it)
                                }
                                initialPersonnalities()!!.forEach {
                                    getInstance(context)!!.personnalityDao().Insert(it)
                                }
                                initalCountryVideos()!!.forEach {
                                    getInstance(context)!!.countryVideoDao().Insert(it)
                                }
                                initalCountryImgs()!!.forEach {
                                    getInstance(context)!!.countryImgDao().insert(it)
                                }

                                initalHistoryEvents()!!.forEach {
                                    getInstance(context)!!.countryHistoryEventDao().insert(it)
                                }

                                initalRessources()!!.forEach {
                                    getInstance(context)!!.ressourceDao().insert(it)
                                }
                            })
                    }
                })
                .build()
        }
    }
}