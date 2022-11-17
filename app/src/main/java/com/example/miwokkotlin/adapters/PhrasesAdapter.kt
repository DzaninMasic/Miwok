package com.example.miwokkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.models.PhrasesModel
import com.example.miwokkotlin.R

class PhrasesAdapter(var context: Context, var phrasesModels: ArrayList<PhrasesModel>) : RecyclerView.Adapter<PhrasesAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.miwokLanguage.text = phrasesModels[position].miwokLanguage
        holder.englishLanguage.text = phrasesModels[position].englishLanguage
        //holder.image.setImageResource(miwokPhrasesModels[position].image)
        holder.image.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return phrasesModels.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var miwokLanguage: TextView
        var englishLanguage: TextView
        var image: ImageView

        init {
            miwokLanguage = itemView.findViewById(R.id.miwokLanguage)
            englishLanguage = itemView.findViewById(R.id.englishLanguage)
            image = itemView.findViewById(R.id.imageIcon)
        }
    }
}