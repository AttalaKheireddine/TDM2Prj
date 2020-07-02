package com.example.thetdmproject

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.view.contentcapture.ContentCaptureCondition
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.country_detail.*
import java.util.concurrent.Executors


class CountryDetailActivity : AppCompatActivity() {

    private var db: CountriesDB? = null
    private lateinit var country:Country
    private lateinit var ressources : List<Resource>
    private lateinit var personnalities :List<Personnality>
    private lateinit var categs:List<RessourceCategory>
    private lateinit var country_name:String
    private lateinit var images : List<CountryImg>

    //those for the sounds
    var mMediaPlayer: MediaPlayer? = null
    var  isplaying = false
    val mCompletionListener = MediaPlayer.OnCompletionListener { releaseMediaPlayer() }

    private fun releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_detail)
        country_name = intent.getSerializableExtra("pays") as String
        get_pays(this)
        hymne_btn.setOnClickListener({
            if(isplaying) {

                mMediaPlayer?.release()
                hymne_btn.text = "National Anthem"
                isplaying = false

            }
            else{
                val resID = resources.getIdentifier(country.anthem, "raw", packageName)
                mMediaPlayer = MediaPlayer.create(this as CountryDetailActivity, resID)
                mMediaPlayer?.start()
                isplaying = true
                mMediaPlayer?.setOnCompletionListener(mCompletionListener)
                hymne_btn.text = "Stop National Anthem"
            }
        })

        video_btn.setOnClickListener({
            val intent = Intent(this, VideoActivity::class.java)
            intent.putExtra("pays",country_name)
            this?.startActivity(intent)
        })
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
                        ressources = initalRessources()!!.filter { it.countryName == country_name }
                        personnalities = db!!.personnalityDao().loadAllByCountry(country_name)
                        val cc =MutableList<RessourceCategory>(ressources.size,{db!!.ressouceCategDao().loadByName(ressources[it].ressourceName)[0]})
                        categs = cc.toList()
                    })
                return null
            }

            override fun onPostExecute(result: Void?) {

                super.onPostExecute(result)
                setupRecyclerview(personnalities)
                flag.setImageURI(DBFileURI(country.flag,packageName))
                the_description.text = country.description
                country_name_text.text = country_name
                population.text = "population = ${country.population} square Km"
                surface.text = "surface = ${country.surface} Million people"
                var text_res:String=""
                for (x in 0 until ressources.size)
                {
                    text_res+= "${ressources[x].amount} ${categs[x].unit} of ${ressources[x].ressourceName} \n"
                }
                ressources_tv.text = text_res
                slider.setItems( List<String>(images!!.size,{DBFilePath(images!![it].image,packageName)}))
            }


        }.execute()
    }
}
