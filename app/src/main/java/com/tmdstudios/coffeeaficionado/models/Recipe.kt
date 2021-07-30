package com.tmdstudios.coffeeaficionado.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "coffee_recipes")
data class Recipe (
    var name: String,
    var coffeeBrand: String,
    var brewingMethod: String,
    var coffeeAmount: String,
    var coffeeUnits: String,
    var waterAmount: String,
    var waterUnits: String,
    var milk: String,
    var sugar: String,
    var notes: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
): Parcelable