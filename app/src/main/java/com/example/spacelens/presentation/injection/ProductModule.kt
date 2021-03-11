package com.example.spacelens.presentation.injection

import com.example.spacelens.data.repositories.ProductRepositoryImpl
import com.example.spacelens.domain.repositories.ProductRepository
import com.example.spacelens.domain.usecases.GetProductListUseCase
import dagger.Module
import dagger.Provides

@Module
class ProductModule {

    @Provides
    fun provideProductRepository() : ProductRepository{
        return ProductRepositoryImpl()
    }
    @Provides
    fun provideGetProductsUseCase(productRepository: ProductRepository): GetProductListUseCase{
        return GetProductListUseCase(productRepository)
    }
}