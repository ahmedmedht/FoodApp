package com.example.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detalls.*

class FoodDetalls : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detalls)
        val bundle=intent.extras
        val name = bundle?.getString("name")
        val desc = bundle?.getString("desc")
        val img = bundle?.getInt("img")


        if (img != null) {
            img2.setImageResource(img)
        }
        nameimg.setText(name)
        descimg.setText(desc)
    }
}