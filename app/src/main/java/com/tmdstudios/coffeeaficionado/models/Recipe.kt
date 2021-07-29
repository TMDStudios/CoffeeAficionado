package com.tmdstudios.coffeeaficionado.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_recipes")
data class Recipe (
    var name: String,
    var coffeeBrand: String,
    var brewingMethod: String,
    var coffeeAmount: Float,
    var coffeeMeasurement: String,
    var waterAmount: Float,
    var waterMeasurement: String,
    var milkType: String,
    var sugarType: String,
    var sugarAmount: Float,
    var sugarMeasurement: String,
    var notes: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)