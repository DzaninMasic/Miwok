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

class PhrasesFragment : Fragment() {
    var phrasesModels: ArrayList<BaseModel> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phrases, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var recyclerView: RecyclerView = view.findViewById(R.id.myRecyclerViewPhrases)

        setMiwokPhrasesModels()

        val adapter = BaseAdapter(requireContext(),phrasesModels)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setMiwokPhrasesModels(){
        val miwokLanguage = resources.getStringArray(R.array.miwok_phrases)
        val englishLanguage = resources.getStringArray(R.array.english_phrases)

        for(i in miwokLanguage.indices){
            phrasesModels.add(BaseModel(miwokLanguage[i],englishLanguage[i]))
        }
    }
}