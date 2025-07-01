package com.example.merca

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.merca.adapter.ProductAdapter
import com.example.merca.databinding.ActivityMainBinding
import com.example.merca.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.products.observe(this) { productList ->
            binding.recyclerView.adapter = ProductAdapter(productList)
        }
    }
}