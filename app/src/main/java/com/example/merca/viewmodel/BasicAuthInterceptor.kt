package com.example.merca.viewmodel

import okhttp3.Interceptor
import okhttp3.Response
import java.util.Base64

class BasicAuthInterceptor(private val username: String, private val password: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val credentials = "$username:$password"
        val basicAuth = "Basic " + Base64.getEncoder().encodeToString(credentials.toByteArray())
        val request = chain.request().newBuilder()
            .addHeader("Authorization", basicAuth)
            .build()
        return chain.proceed(request)
    }
}