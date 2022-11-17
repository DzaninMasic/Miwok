package com.example.miwokkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.models.ColorsModel
import com.example.miwokkotlin.R

class ColorsAdapter(var context: Context, var miwokColorsModels: ArrayList<ColorsModel>) : RecyclerView.Adapter<ColorsAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.miwokLanguage.text = miwokColorsModels[position].miwokColor
        holder.englishLanguage.text = miwokColorsModels[position].englishColor
        holder.imageView.setImageResource(miwokColorsModels[position].image)
    }

    override fun getItemCount(): Int {
        return miwokColorsModels.size
    }

    class MyViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView){
        var miwokLanguage: TextView
        var englishLanguage: TextView
        var imageView: ImageView

        init {
            miwokLanguage = itemView.findViewById(R.id.miwokLanguage)
            englishLanguage = itemView.findViewById(R.id.englishLanguage)
            imageView = itemView.findViewById(R.id.imageIcon)
        }
    }
}