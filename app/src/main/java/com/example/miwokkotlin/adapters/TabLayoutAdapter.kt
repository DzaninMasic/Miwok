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
            0 -> BaseFragment(data.numbersModels)
            1 -> BaseFragment(data.familyModels)
            2 -> BaseFragment(data.colorsModels)
            3 -> BaseFragment(data.phrasesModels)
            else -> throw Exception("Unknown fragment.")
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}