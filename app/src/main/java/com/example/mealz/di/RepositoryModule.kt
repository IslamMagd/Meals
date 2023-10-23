package com.example.mealz.di

import com.example.data.remote.ServiceApi
import com.example.data.repo.MealsRepositoryImpl
import com.example.domain.repo.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepo(serviceApi: ServiceApi): MealsRepository{
        return MealsRepositoryImpl(serviceApi)
    }

}