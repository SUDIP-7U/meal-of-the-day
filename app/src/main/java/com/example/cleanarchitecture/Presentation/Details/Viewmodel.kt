package com.example.cleanarchitecture.Presentation.Details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.Domain.UseCase.GetmealDeatailsusecase
import com.example.cleanarchitecture.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(private val usecase: GetmealDeatailsusecase) : ViewModel() {

    private val _homeMeal = MutableStateFlow(Datastate())
    val detailsMeal: StateFlow<Datastate>
        get() = _homeMeal

    fun getMealDetailsData(mealId: String) {
        viewModelScope.launch {
            usecase.invoke(mealId).collect { response ->

                when (response) {
                    is Resource.Error -> {
                        _homeMeal.value = Datastate(error = response.message)
                    }

                    is Resource.Loading -> {
                        _homeMeal.value = Datastate(loading = true)
                    }
                    is Resource.Success -> {
                        _homeMeal.value = Datastate(homeData = response.data)

                    }
                }
            }
        }
    }
}





