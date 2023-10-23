package com.example.data.repo

import com.example.data.remote.ServiceApi
import com.example.domain.entity.Category
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsRepository

class MealsRepositoryImpl(private val serviceApi: ServiceApi):MealsRepository {
    override suspend fun getMealsFromRemote(): CategoryResponse = serviceApi.getMeals()
}