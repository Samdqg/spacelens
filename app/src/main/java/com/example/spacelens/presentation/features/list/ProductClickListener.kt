package com.example.spacelens.presentation.features.list

import com.example.spacelens.domain.entities.Product

interface ProductClickListener {
    fun onClickProduct(product: Product)
}