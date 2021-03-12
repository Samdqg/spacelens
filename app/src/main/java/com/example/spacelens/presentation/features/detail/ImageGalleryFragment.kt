package com.example.spacelens.presentation.features.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacelens.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_gallery.*

class ImageGalleryFragment : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.with(activity)
            .load(param1)
            .into(imgProduct)
    }
    companion object {

        private const val URL = "url"

        @JvmStatic
        fun newInstance(param1: String) =
            ImageGalleryFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, param1)
                }
            }
    }
}