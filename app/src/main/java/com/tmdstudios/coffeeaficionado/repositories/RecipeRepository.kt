package com.tmdstudios.coffeeaficionado.repositories

import androidx.lifecycle.LiveData
import com.tmdstudios.coffeeaficionado.adapters.RecipeDao
import com.tmdstudios.coffeeaficionado.models.Recipe


class RecipeRepository(private val recipeDao: RecipeDao) {

    val getAllRecipes: LiveData<List<Recipe>> = recipeDao.getAllRecipes()

    suspend fun addRecipe(recipe: Recipe){
        recipeDao.addRecipe(recipe)
    }
}