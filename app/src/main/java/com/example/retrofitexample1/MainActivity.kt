package com.example.retrofitexample1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = findViewById<TextView>(R.id.id)
        val name = findViewById<TextView>(R.id.name)
        val description = findViewById<TextView>(R.id.description)
        val price = findViewById<TextView>(R.id.price)
        val discount_amount = findViewById<TextView>(R.id.discount_amount)

        GlobalScope.launch(Dispatchers.IO) {
            val call = RetrofitInstance.Retrofit_Instance.retrofit.create(RequestApi::class.java)
                .getSingleUser()

            val user_id = call.execute().body()?.id.toString()
            /*val user_name = call.execute().body()?.name
            val user_description = call.execute().body()?.description
            val user_price = call.execute().body()?.price
            val user_discount_amount = call.execute().body()?.discount_amount*/

            withContext(Dispatchers.Main) {
                id.text = user_id
                /*name.text = user_name
                description.text = user_description
                price.text = user_price
                discount_amount.text = user_discount_amount*/
            }
        }
    }
}