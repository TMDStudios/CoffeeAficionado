package com.tmdstudios.coffeeaficionado.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmdstudios.coffeeaficionado.R
import com.tmdstudios.coffeeaficionado.models.Recipe
import kotlinx.android.synthetic.main.recipe_card.view.*

class RecyclerAdapter(
    private val context: Context,
    private val recipes: List<Recipe>):
    RecyclerView.Adapter<RecyclerAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recipe_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]

        holder.itemView.apply {
            tvRecipeTitle.text = recipe.name
        }
    }

    override fun getItemCount() = recipes.size


}