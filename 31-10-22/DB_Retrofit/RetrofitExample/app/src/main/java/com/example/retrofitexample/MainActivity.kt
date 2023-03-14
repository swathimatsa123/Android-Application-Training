package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
19
class MainActivity : AppCompatActivity() {
    var deathList = ArrayList<DataModel>()
    lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.recyclerView)

        getDeaths()
    }

    private fun getDeaths() {
        val client = APIClient().getRetroFitClient().create(APIINTERFACE::class.java)
        client.getDeaths().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                // Used for inserting data in arraylist of type DataModel
                deathList = response.body() as ArrayList<DataModel>
                val adapter = RecyclerAdapter(deathList)

                // For showing data list vertically

                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = adapter

            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Playing Closure Music", Toast.LENGTH_LONG).show()
            }

        })
    }


}