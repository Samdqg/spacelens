package com.example.spacelens.data.retrofit

import com.example.spacelens.data.entities.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {

    @GET("products_list.php/")
    suspend fun getProductList(@Query("latitude") lat: Int,
                               @Query("longitude") long: Int,
                               @Query("page") page: Int): ProductsResponse
}