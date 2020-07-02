package com.example.thetdmproject

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.video_acti.*
import java.util.concurrent.Executors


class VideoActivity: AppCompatActivity() {

    private lateinit var wideos:List<CountryVideo>
    private lateinit var country_name:String
    private lateinit var images : List<CountryImg>
    private var db: CountriesDB? =null

    //those for the sounds


    private fun setupRecyclerview(personnality_list: List<CountryVideo>) {


        val adapter = VideoRecyclerAdapter(this, personnality_list.toMutableList())
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_acti)
        country_name = intent.getSerializableExtra("pays") as String
        get_pays(this)

    }


    fun get_pays(context: VideoActivity) {
        object : AsyncTask<Void, Void, Void>() {

            override fun doInBackground(vararg voids: Void): Void? {
                db = CountriesDB.getInstance(context)

                Executors.newSingleThreadScheduledExecutor()
                    .execute(Runnable {

                        wideos = db!!.countryVideoDao().loadAllByCountry(country_name)
                    })
                return null
            }

            override fun onPostExecute(result: Void?) {

                super.onPostExecute(result)
                setupRecyclerview(wideos)
            }


        }.execute()
    }
}
