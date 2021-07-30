package com.tmdstudios.coffeeaficionado.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tmdstudios.coffeeaficionado.R
import com.tmdstudios.coffeeaficionado.fragments.list.ListFragmentDirections
import com.tmdstudios.coffeeaficionado.models.Recipe
import kotlinx.android.synthetic.main.recipe_card.view.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.RecipeViewHolder>() {

    private var recipes = emptyList<Recipe>()

    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recipe_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]

        holder.itemView.apply {
            tvRecipeName.text = recipe.name
            cvRecipeCard.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(recipe)
                findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount() = recipes.size

    fun setData(recipes: List<Recipe>){
        this.recipes = recipes
        notifyDataSetChanged()
    }
}