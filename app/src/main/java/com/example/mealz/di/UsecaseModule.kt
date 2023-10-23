package com.example.mealz.di

import com.example.domain.repo.MealsRepository
import com.example.domain.usecase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {
    @Provides
    fun provideUseCase(mealsRepository: MealsRepository): GetMealz{
        return GetMealz(mealsRepository)
    }
}