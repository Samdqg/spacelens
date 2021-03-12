package com.example.spacelens.domain.repositories

import com.example.spacelens.domain.entities.Product

interface ProductRepository {
    suspend fun getProducts(page: Int): List<Product>
}