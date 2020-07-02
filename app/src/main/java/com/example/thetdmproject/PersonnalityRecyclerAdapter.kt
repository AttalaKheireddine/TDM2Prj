package com.example.thetdmproject



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.famous_person.view.*


class PersonnalityRecyclerAdapter (private val context: Context?, private var list: MutableList<Personnality>) :
    RecyclerView.Adapter<PersonnalityRecyclerAdapter.MyViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.famous_person, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
    }

    override fun getItemCount(): Int = list.size



    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: Personnality

        fun setData(current:Personnality, position: Int) {

            if (context != null) {
                itemView.personPic.setImageURI(DBFileURI(current.photo,context.packageName))
            }
            itemView.personName.text ="${current.fullName} (${current.Bdate}-${current.Ddate})"
            itemView.descriptionText.text = current.description
            this.pos = position
            this.current = current
        }

    }
}