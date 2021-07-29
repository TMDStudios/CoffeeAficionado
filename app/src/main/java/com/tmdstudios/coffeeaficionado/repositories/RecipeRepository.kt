package com.tmdstudios.coffeeaficionado.repositories

import androidx.lifecycle.MutableLiveData
import com.tmdstudios.coffeeaficionado.models.Recipe


class RecipeRepository {
    private var instance: RecipeRepository? = null
    private val dataSet: ArrayList<Recipe> = ArrayList()

    fun getInstance(): RecipeRepository? {
        if (instance == null) {
            instance = RecipeRepository()
        }
        return instance
    }


    // Pretend to get data from a webservice or online source
    fun getRecipes(): MutableLiveData<List<Recipe>> {
        setRecipes()
        val data: MutableLiveData<List<Recipe>> = MutableLiveData<List<Recipe>>()
        data.value = dataSet
        return data
    }

    private fun setRecipes() {
        dataSet.add(
            Recipe(
                "Recipe 1",
                "Starbucks",
                "Mr. Coffee",
                5f,
                "Spoons",
                .1f,
                "Coffee Pitcher",
                "cream",
                "brown granulated",
                1f,
                "spoon",
                "none"
            )
        )
        dataSet.add(
            Recipe(
                "Recipe 2",
                "PNC",
                "Mr. Coffee",
                5f,
                "Spoons",
                .1f,
                "Coffee Pitcher",
                "cream",
                "brown granulated",
                1f,
                "spoon",
                "bad"
            )
        )
        dataSet.add(
            Recipe(
                "Recipe 3",
                "Dunkin",
                "Mr. Coffee",
                5f,
                "Spoons",
                .1f,
                "Coffee Pitcher",
                "cream",
                "brown granulated",
                1f,
                "spoon",
                "haven't tried"
            )
        )
    }
}