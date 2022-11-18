package com.example.miwokkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.R
import com.example.miwokkotlin.models.BaseModel

class BaseAdapter(val context: Context, val baseModels: ArrayList<BaseModel>, val onItemListener: OnItemListener): RecyclerView.Adapter<BaseAdapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        var itemView = layoutInflater.inflate(R.layout.item_view,parent,false)
        return TestViewHolder(itemView, onItemListener)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.miwokLanguage.text = baseModels[position].miwokLanguage
        holder.englishLanguage.text = baseModels[position].englishLanguage
        if(baseModels[position].image == null){
            holder.image.isVisible = false
        }
        else{
            baseModels[position].image?.let { image ->
                holder.image.setImageResource(image)
            }
        }
        //holder.image.setImageResource(baseModels[position].image)
    }

    override fun getItemCount(): Int {
        return baseModels.size
    }

    class TestViewHolder(itemView: View, onItemListener: OnItemListener) : RecyclerView.ViewHolder(itemView){
        var miwokLanguage: TextView
        var englishLanguage: TextView
        var image: ImageView

        init {
            miwokLanguage = itemView.findViewById(R.id.miwokLanguage)
            englishLanguage = itemView.findViewById(R.id.englishLanguage)
            image = itemView.findViewById(R.id.imageIcon)
            itemView.setOnClickListener{
                onItemListener.onItemClick(adapterPosition)
            }
        }
    }

    interface OnItemListener{
        fun onItemClick(position: Int)
    }
}