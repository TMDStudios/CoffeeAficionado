package com.tmdstudios.coffeeaficionado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tmdstudios.coffeeaficionado.adapters.RecyclerAdapter
import com.tmdstudios.coffeeaficionado.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var rvRecipes: RecyclerView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecipes = findViewById(R.id.rvRecipes)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecipes().observe(this, Observer { rvRecipes.adapter!!.notifyDataSetChanged() })

        button = findViewById(R.id.button)

        rvRecipes.adapter = RecyclerAdapter(this, viewModel.getRecipes().value!!)
        rvRecipes.layoutManager = LinearLayoutManager(this)
    }
}