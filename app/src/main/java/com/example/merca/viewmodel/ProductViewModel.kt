package com.example.merca.viewmodel


import androidx.lifecycle.*
import com.example.merca.model.Product
import com.example.merca.network.ApiService
import com.example.merca.repository.ProductRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductViewModel : ViewModel() {

    private val api = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:3000/") // Cambiar por tu API
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    private val repository = ProductRepository(api)

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}