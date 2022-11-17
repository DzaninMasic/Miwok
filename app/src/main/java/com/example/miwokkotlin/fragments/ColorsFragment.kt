package com.example.miwokkotlin.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.example.miwokkotlin.R
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.adapters.BaseAdapter
import com.example.miwokkotlin.models.BaseModel

class ColorsFragment : Fragment() {
    var miwokColorsModels: ArrayList<BaseModel> = ArrayList()
    val miwokColorsImages = intArrayOf(R.drawable.color_red, R.drawable.color_mustard_yellow, R.drawable.color_dusty_yellow, R.drawable.color_green,
        R.drawable.color_brown, R.drawable.color_gray, R.drawable.color_black, R.drawable.color_white)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.myRecyclerViewColors)

        setMiwokColorsModels()

        val adapter = BaseAdapter(requireContext(),miwokColorsModels)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setMiwokColorsModels(){
        val miwokLanguage = resources.getStringArray(R.array.miwok_colors)
        val englishLanguage = resources.getStringArray(R.array.english_colors)

        for(i in miwokLanguage.indices){
            miwokColorsModels.add(BaseModel(miwokLanguage[i],englishLanguage[i],miwokColorsImages[i]))
        }
    }
}