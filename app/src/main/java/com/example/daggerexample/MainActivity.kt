package com.example.daggerexample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerexample.`interface`.API
import com.example.daggerexample.model.Hero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView

    //injecting retrofit
    @Inject
    lateinit var retrofit: Retrofit


    //@Inject lateinit var retrofit : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listViewHeroes)
        (application as MyApplication).getNetComponent().inject(this)
        callAPI()

    }

    private fun callAPI() {

        //val api: API = retrofit!!.create(API::class.java)
        //val call: Call<List<Hero>> = api.getHeroes()

        val call: Call<List<Hero>> = retrofit.create(API::class.java).getHeroes()
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                val heroList = response.body()!!

                //Creating an String array for the ListView
                val heroes = arrayOfNulls<String>(heroList.size)

                //looping through all the heroes and inserting the names inside the string array
                for (i in heroList.indices) {
                    heroes[i] = heroList[i].name
                }

                //displaying the string array into listview
                listView.adapter =
                    ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, heroes)
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })

    }
}