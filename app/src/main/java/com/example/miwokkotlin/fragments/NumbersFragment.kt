package com.example.miwokkotlin.fragments

import com.example.miwokkotlin.adapters.NumbersAdapter.OnNumberListener
import com.example.miwokkotlin.models.NumberModel
import com.example.miwokkotlin.R
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miwokkotlin.adapters.NumbersAdapter
import java.util.ArrayList

class NumbersFragment : Fragment(), OnNumberListener {
    var numberModels = ArrayList<NumberModel>()
    var miwokNumberImages = intArrayOf(R.drawable.number_one, R.drawable.number_two, R.drawable.number_three, R.drawable.number_four,
            R.drawable.number_five, R.drawable.number_six, R.drawable.number_seven, R.drawable.number_eight, R.drawable.number_nine,
            R.drawable.number_ten)
    var miwokNumberSounds = intArrayOf(R.raw.number_one, R.raw.number_two, R.raw.number_three, R.raw.number_four, R.raw.number_five,
            R.raw.number_six, R.raw.number_seven, R.raw.number_eight, R.raw.number_nine, R.raw.number_ten)
    var mediaPlayer: MediaPlayer? = MediaPlayer()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.myRecyclerView)

        setMiwokNumberModels()

        val adapter = NumbersAdapter(requireContext(),numberModels, this)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
    }

    private fun setMiwokNumberModels() {
        val miwokNumbers = resources.getStringArray(R.array.numbers_miwok)
        val englishNumbers = resources.getStringArray(R.array.numbers_english)
        for (i in miwokNumbers.indices) {
            numberModels.add(NumberModel(miwokNumbers[i], englishNumbers[i], miwokNumberImages[i], miwokNumberSounds[i]))
        }
    }

    override fun onNumberClick(position: Int) {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
        mediaPlayer = MediaPlayer.create(requireContext(), numberModels[position].sound)
        mediaPlayer?.start()
    }
}