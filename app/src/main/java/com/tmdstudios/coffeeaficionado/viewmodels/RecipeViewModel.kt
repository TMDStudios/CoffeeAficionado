package com.tmdstudios.coffeeaficionado.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tmdstudios.coffeeaficionado.data.RecipeDatabase
import com.tmdstudios.coffeeaficionado.models.Recipe
import com.tmdstudios.coffeeaficionado.repositories.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application): AndroidViewModel(application) {

    private val allRecipes: LiveData<List<Recipe>>
    private val repository: RecipeRepository

    init {
        val recipeDao = RecipeDatabase.getDatabase(application).recipeDao()
        repository = RecipeRepository(recipeDao)
        allRecipes = repository.getAllRecipes
    }

    fun getAllRecipes(): LiveData<List<Recipe>>{
        return allRecipes
    }

    fun addRecipe(recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRecipe(recipe)
        }
    }

    fun updateRecipe(recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRecipe(recipe)
        }
    }

}