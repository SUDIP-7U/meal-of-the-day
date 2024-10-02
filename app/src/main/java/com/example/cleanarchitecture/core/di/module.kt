package com.example.cleanarchitecture.core.di

import com.example.cleanarchitecture.Data.Repository_impl.repoimpl
import com.example.cleanarchitecture.Data.remote.mealApiService
import com.example.cleanarchitecture.Domain.Repository.mealrepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object module {

    @Provides
    @Singleton
  fun provideRetrofit():Retrofit{

      return Retrofit.Builder()
          .baseUrl("")
          .addConverterFactory(GsonConverterFactory.create())
          .build()

    }
    @Provides
    @Singleton
fun apiservice (retrofit: Retrofit):mealApiService{

    return retrofit.create(mealApiService::class.java)

    }

    @Provides
    @Singleton
    fun providerepo(apiService: mealApiService) : mealrepository{
        return repoimpl(apiService)

    }
}