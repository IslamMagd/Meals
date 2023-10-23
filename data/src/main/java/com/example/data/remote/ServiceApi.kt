package com.example.data.remote

import com.example.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ServiceApi {
     @GET("categories.php")
    suspend fun getMeals():CategoryResponse
}