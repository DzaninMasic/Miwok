package com.example.miwokkotlin.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.R
import com.example.miwokkotlin.adapters.MiwokAdapter
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.models.MiwokModel

class MiwokFragment private constructor(val data: ArrayList<MiwokModel>?) : Fragment(), MiwokAdapter.OnItemListener {
    var mediaPlayer: MediaPlayer? = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_miwok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView= view.findViewById(R.id.myRecyclerView)

        val adapter = data?.let { MiwokAdapter(requireContext(), it, this) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onItemClick(position: Int) {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
        mediaPlayer = data?.get(position)?.let { MediaPlayer.create(requireContext(), it.sound) }
        mediaPlayer?.start()
    }

    //.create companion object
    companion object {
        fun create(context: Context, test: MiwokEnum):Fragment{
            val data = DataSource(context)
            when(test) {
                MiwokEnum.NUMBERS -> {
                    return MiwokFragment(data.numbersModels)
                }
                MiwokEnum.FAMILY -> {
                    return MiwokFragment(data.familyModels)
                }
                MiwokEnum.COLORS -> {
                    return MiwokFragment(data.colorsModels)
                }
                MiwokEnum.PHRASES -> {
                    return MiwokFragment(data.phrasesModels)
                }
            }
        }
    }
}