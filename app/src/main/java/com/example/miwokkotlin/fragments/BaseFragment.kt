package com.example.miwokkotlin.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.R
import com.example.miwokkotlin.adapters.BaseAdapter
import com.example.miwokkotlin.models.BaseModel

class BaseFragment(val data: ArrayList<BaseModel>?) : Fragment(), BaseAdapter.OnItemListener {
    var mediaPlayer: MediaPlayer? = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView= view.findViewById(R.id.myRecyclerView)

        val adapter = data?.let { BaseAdapter(requireContext(), it, this) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
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

}