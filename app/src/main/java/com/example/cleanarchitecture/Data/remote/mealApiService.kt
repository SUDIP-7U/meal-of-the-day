package com.example.cleanarchitecture.Data.remote

import com.example.cleanarchitecture.Data.DTO.responseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface mealApiService {
    @GET("json/v1/1/filter.php?c=Dessert")

    suspend fun getmealList(
        @Query("c") mealname : String = "Dessert"
    ):Response<responseDTO>
}