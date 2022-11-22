package com.example.miwokkotlin.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.Fragment
import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.datasource.DataSource
import com.example.miwokkotlin.fragments.*

class TabLayoutAdapter(val fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    //val data = DataSource(fragmentActivity)
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MiwokFragment.create(fragmentActivity, MiwokEnum.NUMBERS)
            1 -> MiwokFragment.create(fragmentActivity, MiwokEnum.FAMILY)
            2 -> MiwokFragment.create(fragmentActivity, MiwokEnum.COLORS)
            3 -> MiwokFragment.create(fragmentActivity, MiwokEnum.PHRASES)
            else -> throw Exception("Unknown fragment.")
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}