package com.example.miwokkotlin

import com.example.miwokkotlin.models.MiwokModel

interface CategoryView {
    fun showData(data: ArrayList<MiwokModel>)
}