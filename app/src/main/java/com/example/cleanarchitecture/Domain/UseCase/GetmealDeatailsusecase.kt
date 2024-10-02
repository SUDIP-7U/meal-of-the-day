package com.example.cleanarchitecture.Domain.UseCase

import android.util.Log
import com.example.cleanarchitecture.Data.DTO.toDomain
import com.example.cleanarchitecture.Domain.Model.MealDetails
import com.example.cleanarchitecture.Domain.Repository.mealrepository
import com.example.cleanarchitecture.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetmealDeatailsusecase @Inject constructor (private val repository: mealrepository) {

    operator fun invoke(mealId: String): Flow<Resource<List<MealDetails?>?>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getMealDetails(mealId)
            if (data.isSuccessful && data.body() != null) {
                Log.d("Exception", "invoke:")
                val ml = data.body()!!.meals
                val mlItem = ml.map { it.toDomain() }
                emit(Resource.Success(mlItem))
            }
        } catch (e: Exception) {
           Log.d("Exception", "invoke: ${e.message}")
           emit(Resource.Error(e.message ?: "Some Error"))
       }
    }
}




