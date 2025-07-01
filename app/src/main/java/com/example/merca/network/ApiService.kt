package com.example.merca.network

import com.example.merca.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}