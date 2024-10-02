package com.example.cleanarchitecture.Presentation.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.Domain.UseCase.Getmealusecase
import com.example.cleanarchitecture.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val usecase :Getmealusecase) : ViewModel() {

    fun getmealdata(mealname:String) {
        //co-routines & lifescycle libary Need for this
        viewModelScope.launch{
            usecase.invoke(mealname).collect{Response->

                when(Response){
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        Log.d("tahiri", "getmealdata: ${Response.data}")

                    }
                }
            }
        }
    }
}