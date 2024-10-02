package com.example.cleanarchitecture.Presentation.Details

import com.example.cleanarchitecture.Domain.Model.MealDetails


data class Datastate (val loading: Boolean = false,
                      val homeData: List<MealDetails?>? = null,
                      val error: String? = null)

