package com.example.cleanarchitecture.Data.Repository_impl

import com.example.cleanarchitecture.Data.DTO.ResponseMealsDtoDetails
import com.example.cleanarchitecture.Data.DTO.responseDTO
import com.example.cleanarchitecture.Data.remote.mealApiService
import com.example.cleanarchitecture.Domain.Repository.mealrepository
import retrofit2.Response
import javax.inject.Inject

class repoimpl @Inject constructor(private val apiService: mealApiService) :mealrepository{
    override suspend fun getmealList(mealname: String): Response<responseDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun getMealDetails(mealId: String): Response<ResponseMealsDtoDetails> {
        TODO("Not yet implemented")
    }
}