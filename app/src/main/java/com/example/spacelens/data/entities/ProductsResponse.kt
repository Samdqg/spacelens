package com.example.spacelens.data.entities

import com.example.spacelens.domain.entities.Product

data class ProductsResponse (
    val products: List<Product>
)