package com.example.spacelens.presentation.features.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.spacelens.R
import com.example.spacelens.domain.entities.Product
import com.example.spacelens.presentation.features.detail.ProductDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ProductClickListener{

    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductsAdapter

    companion object{
        const val product_key = "product"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        initObservers()
        initUI()
    }

    override fun onStart() {
        super.onStart()
        getProducts()
    }

    private fun initObservers() {
        viewModel.getProducts().observe(this, Observer {
            refreshList(it)
            hideLoading()
            //Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        })

        viewModel.getException().observe(this, Observer {
            hideLoading()
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        })
    }

    private fun initUI() {
        adapter = ProductsAdapter(this, ArrayList(), this)
        rvProducts.layoutManager = GridLayoutManager(this, 2)
        rvProducts.adapter = adapter
    }

    private fun getProducts(){
        showLoading()
        viewModel.getProductList(0)
    }

    private fun refreshList(products: List<Product>){
        adapter.refresh(products)
    }

    private fun showLoading(){
        pbLoading.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        pbLoading.visibility = View.GONE
    }

    override fun onClickProduct(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(product_key, product)
        startActivity(intent)
    }
}