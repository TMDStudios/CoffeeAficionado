package com.tmdstudios.coffeeaficionado.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmdstudios.coffeeaficionado.R
import com.tmdstudios.coffeeaficionado.adapters.RecyclerAdapter
import com.tmdstudios.coffeeaficionado.viewmodels.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_list_fragment.view.*

class ListFragment : Fragment() {
    private lateinit var recipeViewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_fragment, container, false)

        // Recyclerview
        val adapter = RecyclerAdapter()
        val recyclerView = view.rvRecipeList
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)
        recipeViewModel.getAllRecipes().observe(viewLifecycleOwner, Observer { recipe -> adapter.setData(recipe) })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_list_fragment_to_add_fragment)
        }

        return view
    }

}