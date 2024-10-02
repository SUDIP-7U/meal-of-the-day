package com.example.cleanarchitecture.Presentation.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.Domain.Model.MealDetails
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    val TAG: String = DetailsActivity::class.java.simpleName

    companion object {
        const val MEAL_ITEM_KEY = "MealItemKey"
    }

    private val viewModel: Viewmodel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.detailsMeal.collect { dataState ->

            }
        }
    }
}
    private fun setUiData(homeData: MealDetails?) {
      homeData?.let { recipe ->

            }
       }
//TAGS horizontal by kotlin Tags codes
    private fun setTagsData(tags: List<String>) {
       tags.forEach { tag ->
           LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
           )
       }
   }

//Linear we use Index and for loop code without using RCV ,for conside code and too much caches
   @SuppressLint("ResourceAsColor")
   private fun setIngredients(ingredients: List<String>) {

   }



