package com.tmdstudios.coffeeaficionado.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tmdstudios.coffeeaficionado.R
import com.tmdstudios.coffeeaficionado.models.Recipe
import com.tmdstudios.coffeeaficionado.viewmodels.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.etRecipeNameUpdate.setText(args.currentRecipe.name)
        view.etCoffeeBrandUpdate.setText(args.currentRecipe.coffeeBrand)
        view.etBrewingMethodUpdate.setText(args.currentRecipe.brewingMethod)
        view.etCoffeeAmountUpdate.setText(args.currentRecipe.coffeeAmount)
        view.etCoffeeUnitsUpdate.setText(args.currentRecipe.coffeeUnits)
        view.etWaterAmountUpdate.setText(args.currentRecipe.waterAmount)
        view.etWaterUnitsUpdate.setText(args.currentRecipe.waterUnits)
        view.etMilkUpdate.setText(args.currentRecipe.milk)
        view.etSugarUpdate.setText(args.currentRecipe.sugar)
        view.etNotesUpdate.setText(args.currentRecipe.notes)

        view.btSubmitUpdate.setOnClickListener { updateRecipeData() }

        return view
    }

    private fun updateRecipeData() {
        val recipeName = etRecipeNameUpdate.text.toString()
        val coffeeBrand = etCoffeeBrandUpdate.text.toString()
        val brewingMethod = etBrewingMethodUpdate.text.toString()
        val coffeeAmount = etCoffeeAmountUpdate.text.toString()
        val coffeeUnits = etCoffeeUnitsUpdate.text.toString()
        val waterAmount = etWaterAmountUpdate.text.toString()
        val waterUnits = etWaterUnitsUpdate.text.toString()
        val milk = etMilkUpdate.text.toString()
        val sugar = etSugarUpdate.text.toString()
        val notes = etNotesUpdate.text.toString()

        if(inputCheck(recipeName, coffeeBrand, brewingMethod)){
            val updatedRecipe = Recipe(
                recipeName,
                coffeeBrand,
                brewingMethod,
                coffeeAmount,
                coffeeUnits,
                waterAmount,
                waterUnits,
                milk,
                sugar,
                notes,
                id = args.currentRecipe.id
            )
            recipeViewModel.updateRecipe(updatedRecipe)
            Toast.makeText(requireContext(), "Recipe Updated Successfully", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_list_fragment)
        }else{
            Toast.makeText(requireContext(), "The first three fields are required", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, brand: String, method: String): Boolean{
        return !(name.isEmpty() && brand.isEmpty() && method.isEmpty())
    }

}