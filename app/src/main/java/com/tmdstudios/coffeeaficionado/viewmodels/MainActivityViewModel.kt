package com.tmdstudios.coffeeaficionado.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tmdstudios.coffeeaficionado.models.Recipe
import com.tmdstudios.coffeeaficionado.repositories.RecipeRepository

class MainActivityViewModel: ViewModel() {

    private lateinit var recipeList: MutableLiveData<List<Recipe>>
    private var recipeRepo: RecipeRepository = RecipeRepository()

    init {
        recipeList = recipeRepo.getRecipes()
    }

    fun getRecipes(): LiveData<List<Recipe>>{
        return recipeList
    }
}