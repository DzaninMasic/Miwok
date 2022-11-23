package com.example.miwokkotlin.fragments

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.ContactsContract
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

class MiwokFragment() : Fragment(), MiwokAdapter.OnItemListener {
    private var mediaPlayer: MediaPlayer? = MediaPlayer()
    private var dataSource: DataSource? = null
    private var data: ArrayList<MiwokModel>? = arrayListOf<MiwokModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_miwok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.myRecyclerView)

        dataSource = DataSource(requireContext())

        val unBundled = this.arguments?.get("DATA")

        var type: MiwokEnum? = null
        if (unBundled is MiwokEnum){
            type = unBundled
            Log.i("TAG", unBundled.toString())
        }

        data= dataSource?.getData(type)

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
        mediaPlayer = data?.get(position).let { it?.let { it1 -> MediaPlayer.create(requireContext(), it1.sound) } }
        mediaPlayer?.start()
    }

    //.create companion object
    companion object {
        fun create(test: MiwokEnum): Fragment {
            val bundle = Bundle()
            val fragment: MiwokFragment

            bundle.putSerializable("DATA",test)
            fragment = MiwokFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}














/*when (test) {
    MiwokEnum.NUMBERS -> {
        bundle.putParcelableArrayList(ELEMENTS, data.numbersModels)
        fragment = MiwokFragment()
        fragment.arguments = bundle
        return fragment
    }
    MiwokEnum.FAMILY -> {
        bundle.putParcelableArrayList(ELEMENTS, data.familyModels)
        fragment = MiwokFragment()
        fragment.arguments = bundle
        return fragment
    }
    MiwokEnum.COLORS -> {
        bundle.putParcelableArrayList(ELEMENTS, data.colorsModels)
        fragment = MiwokFragment()
        fragment.arguments = bundle
        return fragment
    }
    MiwokEnum.PHRASES -> {
        bundle.putParcelableArrayList(ELEMENTS, data.phrasesModels)
        fragment = MiwokFragment()
        fragment.arguments = bundle
        return fragment
    }
}*/