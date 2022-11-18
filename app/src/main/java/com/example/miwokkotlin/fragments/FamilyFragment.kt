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

class FamilyFragment : Fragment() {

    var familyModels = ArrayList<BaseModel>()
    var miwokFamilyImages= intArrayOf(R.drawable.family_father, R.drawable.family_mother, R.drawable.family_son,
        R.drawable.family_daughter, R.drawable.family_older_brother, R.drawable.family_younger_brother, R.drawable.family_older_sister,
        R.drawable.family_younger_sister, R.drawable.family_grandmother, R.drawable.family_grandfather)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_family, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.myRecyclerViewFamily)

        setMiwokFamilyModels()

        val adapter = BaseAdapter(requireContext(),familyModels)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
    }

    fun setMiwokFamilyModels(){
        val miwokFamily = resources.getStringArray(R.array.family_miwok)
        val englishFamily = resources.getStringArray(R.array.family_english)
        for(i in miwokFamily.indices){
            familyModels.add(BaseModel(miwokFamily[i],englishFamily[i],miwokFamilyImages[i]))
        }
    }
}