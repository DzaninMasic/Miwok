package com.example.miwokkotlin.presenters

import android.content.Context
import android.media.MediaPlayer
import com.example.miwokkotlin.CategoryView
import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.models.MiwokModel

class MiwokPresenter(private val context: Context, private val fragmentInterface: CategoryView) {

    private var data: ArrayList<MiwokModel>? = arrayListOf()
    private var dataSource = DataSource()
    private var mediaPlayer: MediaPlayer? = null

    fun getData(category: MiwokEnum?) {
        data = dataSource.getData(category)
        data?.let { fragmentInterface.showData(it) }
    }

    fun pauseMedia() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    fun playMedia(position: Int) {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
        mediaPlayer =
            data?.get(position).let { modelFromList ->
                modelFromList?.let { model ->
                    MediaPlayer.create(context, model.sound)
                }
            }
        mediaPlayer?.start()
    }
}