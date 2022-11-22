package com.example.miwokkotlin.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class MiwokModel(var miwokLanguage: String, var englishLanguage: String, var sound: Int, var image: Int?=null)
