package com.example.merca.network

import com.example.merca.model.Product
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers(
        "apikey: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InppaWFqZmdrYnpvcW5uamdqaGtoIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTE0ODYzMzksImV4cCI6MjA2NzA2MjMzOX0.EvrO8lwfhhBRSKEQxHaGc16dXSUgIxpqf3A4H-o2Y44",
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InppaWFqZmdrYnpvcW5uamdqaGtoIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTE0ODYzMzksImV4cCI6MjA2NzA2MjMzOX0.EvrO8lwfhhBRSKEQxHaGc16dXSUgIxpqf3A4H-o2Y44",
        "Content-Type: application/json"
    )
    @GET("producto") // este es el nombre exacto de tu tabla en Supabase
    suspend fun getProducts(): List<Product>
}