package com.example.miwokkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.adapters.NumbersAdapter.MyViewHolder
import android.widget.TextView
import com.example.miwokkotlin.models.NumberModel
import com.example.miwokkotlin.R
import java.util.ArrayList

class NumbersAdapter (var context: Context, var numberModels: ArrayList<NumberModel>, val onNumberListener: OnNumberListener) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Used to inflate the layout
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view, onNumberListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Used for binding the data to the card view
        holder.miwokNumber.text = numberModels[position].miwokNumber
        holder.englishNumber.text = numberModels[position].englishNumber
        holder.imageView.setImageResource(numberModels[position].image)
    }

    override fun getItemCount(): Int {
        return numberModels.size //Number of items / rows
    }

    class MyViewHolder(itemView: View, var onNumberListener: OnNumberListener) : RecyclerView.ViewHolder(itemView) {
        //this changes the values of the cardview items (changes the image and text)
        var imageView: ImageView
        var miwokNumber: TextView
        var englishNumber: TextView

        init {
            imageView = itemView.findViewById(R.id.imageIcon)
            miwokNumber = itemView.findViewById(R.id.miwokLanguage)
            englishNumber = itemView.findViewById(R.id.englishLanguage)
            itemView.setOnClickListener {
                onNumberListener.onNumberClick(adapterPosition)
            }
        }
    }

    interface OnNumberListener {
        fun onNumberClick(position: Int)
    }
}