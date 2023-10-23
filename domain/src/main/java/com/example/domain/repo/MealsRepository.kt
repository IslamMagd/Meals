package com.example.domain.repo

import com.example.domain.entity.Category
import com.example.domain.entity.CategoryResponse

interface MealsRepository {
 suspend fun getMealsFromRemote(): CategoryResponse
}