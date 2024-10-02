package com.example.cleanarchitecture.Domain.Model

import androidx.annotation.Keep

@Keep
data class mealitem(
        val id: String="",
        val title: String="",
        val thumb: String=""
    )
