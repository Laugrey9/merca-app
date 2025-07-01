package com.example.merca.repository

import com.example.merca.model.Product
import com.example.merca.network.ApiService

class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts(): List<Product> {
        return apiService.getProducts()
    }
}