package com.example.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*
import kotlinx.android.synthetic.main.title_ticket.view.*

class MainActivity : AppCompatActivity() {
    var dapter:adapterfood?=null
    var listitem=ArrayList<FoodItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loaditem()
        dapter=adapterfood(listitem,this)

        lvfood.adapter=dapter
    }

    private fun loaditem() {
        listitem.add(FoodItem("name_title","General",R.drawable.sochi))

        listitem.add(FoodItem("Burger","A hamburger (also burger for short) is a food, typically considered a sandwich, consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled.",R.drawable.bur))
        listitem.add(FoodItem("Fries","shoe String Fries, made With just the right amount of crunch and softness",R.drawable.fries))
        listitem.add(FoodItem("Sushi","Sushi is a Japanese dish of prepared vinegared rice (鮨飯, sushi-meshi), usually with some sugar and salt, accompanied by a variety of ingredients (ねた, neta), such as seafood, often raw, and vegetables",R.drawable.sochi))

        listitem.add(FoodItem("name_title","Midlle",R.drawable.sochi))

        listitem.add(FoodItem("Donuts","donut is a type of food made from leavened fried dough. It is popular in many countries and is prepared in various forms as a sweet snack that can be homemade or purchased in bakeries,",R.drawable.don))
        listitem.add(FoodItem("Steak","A beefsteak, often called just steak, is a flat cut of beef with parallel faces, usually cut perpendicular to the muscle fibers. In common restaurant service a single serving has a raw mass ranging from 120 to 600 grams (4 to 21 oz). Beef steaks are usually grilled, pan-fried, or broiled.",R.drawable.st))
        listitem.add(FoodItem("Green Burger","falafel is also becoming known as (green burger) There has been much consternation on Egyptian Twitter over the use of the English-language term (green burger) to refer to falafel.",R.drawable.greenb))

    }
    class adapterfood:BaseAdapter {
        var listitemlocal=ArrayList<FoodItem>()
        var context:Context?=null
        constructor(listitemlocal: ArrayList<FoodItem>,context: Context){
            this.listitemlocal = listitemlocal
            this.context=context
        }


        override fun getCount(): Int {
            return listitemlocal.size
        }

        override fun getItem(p0: Int): Any {
            return listitemlocal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var food=listitemlocal[p0]
            if(food.name=="name_title"){
                var foodview =
                    (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                        R.layout.title_ticket,
                        null
                    )
                foodview.title_txt.text = food.des!!

                return foodview
            }else {

                var foodview =
                    (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                        R.layout.food_ticket,
                        null
                    )
                foodview.txtname.text = food.name!!
                foodview.txtdes.text = food.des!!
                foodview.imgfood.setImageResource(food.img!!)
                foodview.imgfood.setOnClickListener {
                    val intent = Intent(context, FoodDetalls::class.java)
                    intent.putExtra("name", food.name)
                    intent.putExtra("desc", food.des)
                    intent.putExtra("img", food.img)
                    context!!.startActivity(intent)


                }
                return foodview
            }


        }

    }

}


