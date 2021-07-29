package com.tmdstudios.coffeeaficionado.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tmdstudios.coffeeaficionado.R
import com.tmdstudios.coffeeaficionado.models.Recipe
import com.tmdstudios.coffeeaficionado.viewmodels.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_add_fragment.*
import kotlinx.android.synthetic.main.fragment_add_fragment.view.*

class AddFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_fragment, container, false)

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        view.btSubmit.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val recipeName = etRecipeName.text.toString()
        val coffeeBrand = etCoffeeBrand.text.toString()
        val brewingMethod = etBrewingMethod.text.toString()
        val coffeeAmount = etCoffeeAmount.text.toString()
        val coffeeUnits = etCoffeeUnits.text.toString()
        val waterAmount = etWaterAmount.text.toString()
        val waterUnits = etWaterUnits.text.toString()
        val milk = etMilk.text.toString()
        val sugar = etSugar.text.toString()
        val notes = etNotes.text.toString()

        if(inputCheck(recipeName, coffeeBrand, brewingMethod)){
            val recipe = Recipe(
                recipeName,
                coffeeBrand,
                brewingMethod,
                coffeeAmount,
                coffeeUnits,
                waterAmount,
                waterUnits,
                milk,
                sugar,
                notes
            )
            recipeViewModel.addRecipe(recipe)
            Toast.makeText(requireContext(), "Recipe Added Successfully", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_add_fragment_to_list_fragment)
        }else{
            Toast.makeText(requireContext(), "The first three fields are required", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, brand: String, method: String): Boolean{
        return !(name.isEmpty() && brand.isEmpty() && method.isEmpty())
    }

}