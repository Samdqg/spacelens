package com.example.spacelens.data.repositories

import com.example.spacelens.data.retrofit.ProductApiService
import com.example.spacelens.data.retrofit.RetrofitBase
import com.example.spacelens.domain.entities.Product
import com.example.spacelens.domain.repositories.ProductRepository
import retrofit2.create

class ProductRepositoryImpl: ProductRepository {

    val retrofit = RetrofitBase.getRetrofitInstance()
    val productApiService = retrofit.create<ProductApiService>()

    override suspend fun getProducts(page: Int): List<Product> {
        val response = productApiService.getProductList(1,1, page)
        return response.products
    }
}