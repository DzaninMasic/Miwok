package com.example.miwokkotlin.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.miwokkotlin.fragments.NumbersFragment
import com.example.miwokkotlin.fragments.FamilyFragment
import com.example.miwokkotlin.fragments.ColorsFragment
import com.example.miwokkotlin.fragments.PhrasesFragment
import androidx.fragment.app.Fragment

class TabLayoutAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NumbersFragment()
            1 -> FamilyFragment()
            2 -> ColorsFragment()
            3 -> PhrasesFragment()
            else -> throw Exception("Unknown fragment.")
        }
    }

    override fun getItemCount(): Int {
        return 4
    }
}