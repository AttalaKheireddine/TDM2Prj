package com.example.thetdmproject



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.famous_person.view.*
import kotlinx.android.synthetic.main.wideo.view.*


class VideoRecyclerAdapter (private val context: Context?, private var list: MutableList<CountryVideo>) :
    RecyclerView.Adapter<VideoRecyclerAdapter.MyViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.wideo, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
    }

    override fun getItemCount(): Int = list.size



    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: CountryVideo

        fun setData(current:CountryVideo, position: Int) {

            itemView.videoView.setVideoURI(DBFileURI(current.video,context!!.packageName))
            itemView.button.setOnClickListener({
                if (itemView.videoView.isPlaying)
                {
                    itemView.button.text = "PLAY"
                    itemView.videoView.stopPlayback()
                }
                else
                {
                    itemView.button.text = "PLAY"
                    itemView.videoView.start()
                }

            })
        }


    }
}