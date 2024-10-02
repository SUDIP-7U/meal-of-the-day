package com.example.cleanarchitecture.Data.DTO


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.cleanarchitecture.Domain.Model.mealitem

@Keep
data class responseDTO(
    @SerializedName("meals")
    val meals: List<Meal?>?
) {
    @Keep
    data class Meal(
        @SerializedName("idMeal")
        val idMeal: String?,
        @SerializedName("strMeal")
        val strMeal: String?,
        @SerializedName("strMealThumb")
        val strMealThumb: String?
    )
}

fun responseDTO.Meal.tomealitem(): mealitem{
    return mealitem(
        id = this.idMeal.toString(),
        title = this.strMeal.toString(),
        thumb = this.strMealThumb
            ?:"https://images.unsplash.com/photo-1531040630173-7cfb894c8eaa?fm=jpg"

    )
}
//Macbook iPhone
//Hey there i am from anywhere
//nice feature peace🤗🤗🥰🥰🥰😘😍😘😘☺️☺️☺️😊😊😊🙃🙃



