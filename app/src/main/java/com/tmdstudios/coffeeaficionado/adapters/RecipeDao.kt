package com.tmdstudios.coffeeaficionado.adapters

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tmdstudios.coffeeaficionado.models.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: Recipe)

    @Query("SELECT * FROM coffee_recipes ORDER BY id ASC")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Update
    suspend fun updateRecipe(recipe: Recipe)
}