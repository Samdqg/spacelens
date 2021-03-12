package com.example.spacelens.presentation.features.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacelens.presentation.features.map.MapsActivity
import com.example.spacelens.R
import com.example.spacelens.domain.entities.Product
import com.example.spacelens.presentation.features.list.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    var product: Product? = null
    lateinit var dialogGallerry: DialogGallery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        product = intent.getParcelableExtra(MainActivity.product_key)
        initButtons()
        setImage(product!!)
        setData(product!!)
        initDialog()
    }

    private fun initButtons() {
        btnMap.setOnClickListener {
            goToMap()
        }

        btnGallery.setOnClickListener {
            showGallery()
        }
    }

    private fun initDialog(){
        dialogGallerry = DialogGallery(product!!)
    }

    private fun showGallery(){
        dialogGallerry.show(supportFragmentManager, "GalleryFragment")
    }

    private fun setImage(product: Product){
        Picasso.with(this)
            .load(product.attachment.url)
            .into(imgProduct)
    }

    private fun setData(product: Product){
        txtName.text = product.title
        txtDescription.text = product.description
        txtPrice.text = getString(R.string.label_price, product.price.toString())
    }

    private fun goToMap(){
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra(MainActivity.product_key, product)
        startActivity(intent)
    }
}