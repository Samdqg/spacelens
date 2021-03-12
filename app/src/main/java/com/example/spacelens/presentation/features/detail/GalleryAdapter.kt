package com.example.spacelens.presentation.features.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GalleryAdapter (manager: FragmentManager,
                      private val mFragmentList: ArrayList<Fragment>) : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragments(fragments: List<Fragment>){
        mFragmentList.clear()
        mFragmentList.addAll(fragments)
        notifyDataSetChanged()
    }
}