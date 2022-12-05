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
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.models.MiwokModel

class MiwokAdapter(
    val context: Context,
    val miwokModels: ArrayList<MiwokModel>,
    val onItemListener: OnItemListener
) : RecyclerView.Adapter<MiwokAdapter.TestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val itemView = layoutInflater.inflate(R.layout.item_view, parent, false)
        return TestViewHolder(itemView, onItemListener)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        val miwokLanguageArray =
            context.resources.getStringArray(miwokModels[position].miwokLanguageArrayId)
        val englishLanguageArray =
            context.resources.getStringArray(miwokModels[position].englishLanguageArrayId)
        val sounds = miwokModels[position].sound
        holder.sound = sounds
        holder.miwokLanguage.text = miwokLanguageArray[position]
        holder.englishLanguage.text = englishLanguageArray[position]
        if (miwokModels[position].image == null) {
            holder.image.isVisible = false
        } else {
            miwokModels[position].image?.let { image ->
                holder.image.setImageResource(image)
            }
        }
        //holder.image.setImageResource(baseModels[position].image)
    }

    override fun getItemCount(): Int {
        return miwokModels.size
    }

    class TestViewHolder(itemView: View, onItemListener: OnItemListener) :
        RecyclerView.ViewHolder(itemView) {
        var miwokLanguage: TextView
        var englishLanguage: TextView
        var image: ImageView
        var sound: Int = 0

        init {
            miwokLanguage = itemView.findViewById(R.id.miwokLanguage)
            englishLanguage = itemView.findViewById(R.id.englishLanguage)
            image = itemView.findViewById(R.id.imageIcon)
            itemView.setOnClickListener {
                onItemListener.onItemClick(adapterPosition, sound)
            }
        }
    }

    interface OnItemListener {
        fun onItemClick(position: Int, sound: Int)
    }
}