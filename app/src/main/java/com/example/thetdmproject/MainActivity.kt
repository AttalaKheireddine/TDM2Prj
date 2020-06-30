package com.example.thetdmproject

import android.content.res.Configuration
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    private var db: CountriesDB? = null
    lateinit var countries:List<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        get_pays(this)

    }

    private fun setupRecyclerview(country_list: List<Country>) {


        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) { // In landscape
            val middle = country_list.size/2
            val l1 = country_list.subList(0,middle)
            val l2 = country_list.subList(middle,country_list.size)

            val adapter = CountryRecyclerAdapter(this, l1.toMutableList())
            val manager = LinearLayoutManager(this)
            manager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = manager
            recyclerView.adapter = adapter

            val adapter2 = CountryRecyclerAdapter(this, l2.toMutableList())
            val manager2 = LinearLayoutManager(this)
            manager2.orientation = LinearLayoutManager.VERTICAL
            recyclerView2.layoutManager = manager2
            recyclerView2.adapter = adapter2
        } else { // In portrait
            val adapter = CountryRecyclerAdapter(this, country_list.toMutableList())
            val manager = LinearLayoutManager(this)
            manager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = manager
            recyclerView.adapter = adapter
        }

    }

    fun get_pays(context:MainActivity) {
         object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {
                db = CountriesDB.getInstance(context)

                Executors.newSingleThreadScheduledExecutor()
                    .execute(Runnable {

                        val a=db!!.countryDao()
                        val b =a!!.getAll()

                        countries =b

                    })
                                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                setupRecyclerview(countries)
            }
        }.execute()
    }
}
