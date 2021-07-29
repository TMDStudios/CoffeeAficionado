package com.tmdstudios.coffeeaficionado.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_recipes")
data class Recipe (
    var name: String,
    var coffeeBrand: String,
    var brewingMethod: String,
    var coffeeAmount: String,
    var coffeeMeasurement: String,
    var waterAmount: String,
    var waterMeasurement: String,
    var milk: String,
    var sugar: String,
    var notes: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)