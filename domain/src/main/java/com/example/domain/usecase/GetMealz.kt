package com.example.domain.usecase

import com.example.domain.repo.MealsRepository

class GetMealz(private val repository: MealsRepository){
    suspend operator fun invoke() = repository.getMealsFromRemote()
}