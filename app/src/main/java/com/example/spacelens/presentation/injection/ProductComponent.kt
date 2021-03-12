package com.example.spacelens.presentation.injection

import com.example.spacelens.presentation.features.list.ProductViewModel
import dagger.Component

@Component(modules = [ProductModule::class])
interface ProductComponent {
    fun inject(viewModel: ProductViewModel)
}