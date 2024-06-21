package com.example.android2homework28.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android2homework28.ui.fragments.onborad.OnBoardPagingFragment
import com.example.android2homework28.ui.fragments.onborad.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    //это вюпейджер адаптер его два метода

    // сколько листов будет
    override fun getItemCount(): Int {
        return 3
    }

    // это передает позиция там он получает
    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}