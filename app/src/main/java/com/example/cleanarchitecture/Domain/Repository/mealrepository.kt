package com.example.cleanarchitecture.Domain.Repository

import com.example.cleanarchitecture.Data.DTO.ResponseMealsDtoDetails
import com.example.cleanarchitecture.Data.DTO.responseDTO
import retrofit2.Response

interface mealrepository {

   suspend fun getmealList(mealname:String):Response<responseDTO>
   suspend fun getMealDetails(mealId: String): Response<ResponseMealsDtoDetails>

}