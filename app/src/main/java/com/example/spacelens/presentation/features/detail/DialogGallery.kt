package com.example.spacelens.presentation.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.spacelens.R
import com.example.spacelens.domain.entities.Product
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.gallery_layout.*

class DialogGallery(val product: Product) : DialogFragment() {

    private lateinit var pagerAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gallery_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = GalleryAdapter(childFragmentManager, getFragments())

        vpGallery.adapter = pagerAdapter
        tlDots.setupWithViewPager(vpGallery)
    }

    fun getFragments(): ArrayList<Fragment>{
        val fragments = ArrayList<Fragment>()
        val gallery = product.gallery

        gallery.forEach { image->
            fragments.add(ImageGalleryFragment.newInstance(image.src!!))
        }

        return fragments
    }
}