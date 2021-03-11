package com.example.spacelens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spacelens.presentation.features.list.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        initObservers()
        initUI()
    }

    private fun initObservers() {
        viewModel.getProducts().observe(this, Observer {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        })

        viewModel.getException().observe(this, Observer {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        })
    }

    private fun initUI() {
        btnCall.setOnClickListener {
            getProducts()
        }
    }

    private fun getProducts(){
        viewModel.getProductList(0)
    }
}