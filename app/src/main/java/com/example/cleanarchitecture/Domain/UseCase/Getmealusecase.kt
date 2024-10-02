package com.example.cleanarchitecture.Domain.UseCase

import android.util.Log
import com.example.cleanarchitecture.Data.DTO.tomealitem
import com.example.cleanarchitecture.Domain.Model.mealitem
import com.example.cleanarchitecture.Domain.Repository.mealrepository
import com.example.cleanarchitecture.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Getmealusecase @Inject constructor(private val mealrepository: mealrepository){

    operator fun invoke(mealname:String):Flow<Resource<List<mealitem?>?>> = flow {

        try {

            emit(Resource.Loading())
            val data = mealrepository.getmealList(mealname)
            if (data.isSuccessful && data.body()!= null) {
                val ml = data.body()!!.meals
                val mlitem = ml?.map { it?.tomealitem() }
                emit(Resource.Success(mlitem))
            }

        }catch (e:Exception){

            Log.d("Exception", "invoke:${e.message}")
            emit(Resource.Error(e.message?:"some error"))
        }
    }
}

//akhon ami r ki liktam