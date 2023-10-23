package com.example.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealz.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
   private val viewModel : MealsViewModel by viewModels()
    lateinit var mealzAdapter: MealzAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        viewModel.getMeals()

        lifecycleScope.launch {
            viewModel.categories.collect{
                mealzAdapter.submitList(it?.categories)
            }
        }

    }
    private fun setUpRecyclerView(){
        mealzAdapter = MealzAdapter()
        binding.mainRv.apply {
            adapter = mealzAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

}