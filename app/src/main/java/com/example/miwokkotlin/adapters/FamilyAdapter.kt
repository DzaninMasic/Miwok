package com.example.miwokkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.models.FamilyModel
import com.example.miwokkotlin.R

class FamilyAdapter(var context: Context, var familyModels: ArrayList<FamilyModel>) : RecyclerView.Adapter<FamilyAdapter.MyViewHolder>() {
    //INFLATE THE ITEM VIEW
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(context)
        var itemView= inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }

    //BIND DATA TO THE ITEM VIEW HOLDER
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.miwokFamily.text = familyModels[position].miwokFamily
        holder.englishFamily.text = familyModels[position].englishFamily
        holder.imageView.setImageResource(familyModels[position].image)
    }

    override fun getItemCount(): Int {
        return familyModels.size
    }

    class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView){
        var miwokFamily: TextView
        var englishFamily: TextView
        var imageView: ImageView

        init {
            miwokFamily = itemView.findViewById(R.id.miwokLanguage)
            englishFamily = itemView.findViewById(R.id.englishLanguage)
            imageView = itemView.findViewById(R.id.imageIcon)
        }
    }

}