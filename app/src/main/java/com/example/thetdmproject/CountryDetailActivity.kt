package com.example.thetdmproject

import android.content.res.Configuration
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.country_detail.*
import java.util.concurrent.Executors


class CountryDetailActivity : AppCompatActivity() {

    private var db: CountriesDB? = null
    private lateinit var country:Country
    private lateinit var ressources : List<Ressource>
    private lateinit var personnalities :List<Personnality>
    private lateinit var country_name:String
    private lateinit var images : List<CountryImg>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_detail)
        //country_name = intent.getSerializableExtra("pays") as String
       // get_pays(this)

    }

    private fun setupRecyclerview(personnality_list: List<Personnality>) {


        val adapter = PersonnalityRecyclerAdapter(this, personnality_list.toMutableList())
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL

        famous_people.layoutManager = manager
        famous_people.adapter = adapter
    }


    fun get_pays(context:CountryDetailActivity) {
        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {
                db = CountriesDB.getInstance(context)

                Executors.newSingleThreadScheduledExecutor()
                    .execute(Runnable {

                        val a=db!!.countryDao()
                        country = a.loadByName(country_name)[0]
                        images = db!!.countryImgDao().loadAllByCountry(country_name)
                        ressources = db!!.ressourceDao().loadAllByCountry(country_name)
                        personnalities = db!!.personnalityDao().loadAllByCountry(country_name)
                    })
                return null
            }

            override fun onPostExecute(result: Void?) {

                super.onPostExecute(result)
                setupRecyclerview(personnalities)
            }
        }.execute()
    }
}
