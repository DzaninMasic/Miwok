package com.example.miwokkotlin.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.Fragment
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.fragments.*

class TabLayoutAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    val data = DataSource(fragmentActivity)
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MiwokFragment(data.numbersModels)
            1 -> MiwokFragment(data.familyModels)
            2 -> MiwokFragment(data.colorsModels)
            3 -> MiwokFragment(data.phrasesModels)
            else -> throw Exception("Unknown fragment.")
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}