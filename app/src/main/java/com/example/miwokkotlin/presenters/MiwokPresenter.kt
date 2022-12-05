package com.example.miwokkotlin.presenters

import com.example.miwokkotlin.CategoryView
import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.models.MiwokModel
import javax.inject.Inject

class MiwokPresenter @Inject constructor(
    private val dataSource: DataSource
){

    private var data: ArrayList<MiwokModel>? = arrayListOf()
    private var view: CategoryView? = null

    fun attachView(view: CategoryView) {
        this.view = view
    }

    fun destroy() {
        this.view = null
    }

    fun getData(category: MiwokEnum?) {
        data = dataSource.getData(category)
        data?.let { view?.showData(it) }
    }


    /*fun pauseMedia() {
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
    }*/
}