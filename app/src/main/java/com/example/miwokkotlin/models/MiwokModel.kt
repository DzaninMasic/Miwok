package com.example.miwokkotlin.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MiwokModel(
    var miwokLanguageArrayId: Int,
    var englishLanguageArrayId: Int,
    var sound: Int,
    var image: Int? = null
) : Parcelable
