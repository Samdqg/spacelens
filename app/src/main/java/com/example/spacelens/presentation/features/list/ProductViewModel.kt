package com.example.spacelens.presentation.features.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacelens.domain.entities.Product
import com.example.spacelens.domain.usecases.GetProductListUseCase
import com.example.spacelens.presentation.injection.DaggerProductComponent
import com.example.spacelens.presentation.injection.ProductComponent
import com.example.spacelens.presentation.injection.ProductModule
import java.lang.Exception
import javax.inject.Inject

class ProductViewModel : ViewModel() {
    private val productComponent: ProductComponent = DaggerProductComponent
        .builder()
        .productModule(ProductModule())
        .build()

    init {
        productComponent.inject(this)
    }

    @Inject
    lateinit var getProductListUseCase: GetProductListUseCase

    private val products: MutableLiveData<List<Product>> = MutableLiveData()
    private val exception: MutableLiveData<Exception> = MutableLiveData()

    fun getProducts(): LiveData<List<Product>>{
        return products
    }

    fun getException(): LiveData<Exception>{
        return exception
    }

    fun getProductList(page: Int){
        getProductListUseCase.execute({
            onComplete {
                products.value = it
            }
            onError {
                exception.value = it
            }
        }, page)
    }
}