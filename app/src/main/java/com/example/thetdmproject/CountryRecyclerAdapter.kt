package com.example.thetdmproject



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pays_list_item.view.*


class CountryRecyclerAdapter (private val context: Context?, private var list: MutableList<Country>) :
    RecyclerView.Adapter<CountryRecyclerAdapter.MyViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.pays_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
        holder.itemView.countryImgbutton.setOnClickListener {
            val intent = Intent(context, CountryDetailActivity::class.java)
            intent.putExtra("pays",current.name)
            context?.startActivity(intent)

        }
    }

    override fun getItemCount(): Int = list.size



    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: Country

        fun setData(current:Country, position: Int) {
            itemView.country_name_text.text = current.name
            if (context != null) {
                itemView.countryImgbutton.setImageURI(DBFileURI(current.flag,context.packageName))
            }

            this.pos = position
            this.current = current
        }

    }
}