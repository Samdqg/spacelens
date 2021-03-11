package com.example.spacelens.domain.usecases

import com.example.spacelens.domain.entities.Product
import com.example.spacelens.domain.repositories.ProductRepository
import com.example.spacelens.domain.usecases.bases.UseCase

class GetProductListUseCase(private val productRepository: ProductRepository): UseCase<List<Product>, Int>(){
    override suspend fun executeOnBackground(input: Int): List<Product> {
        return productRepository.getProducts(input)
    }
}