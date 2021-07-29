package com.tmdstudios.coffeeaficionado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.tmdstudios.coffeeaficionado.viewmodels.RecipeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RecipeViewModel
    private lateinit var rvRecipes: RecyclerView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))

//        rvRecipes = findViewById(R.id.rvRecipes)
//
//        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        viewModel.getall().observe(this, Observer { rvRecipes.adapter!!.notifyDataSetChanged() })
//
//        button = findViewById(R.id.button)
//
//        rvRecipes.adapter = RecyclerAdapter(this, viewModel.getRecipes().value!!)
//        rvRecipes.layoutManager = LinearLayoutManager(this)
    }
}