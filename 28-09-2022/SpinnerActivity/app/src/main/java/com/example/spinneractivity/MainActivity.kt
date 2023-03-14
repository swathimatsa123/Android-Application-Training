package com.example.spinneractivity


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val yourcountrySpinnerobj = findViewById<Spinner>(R.id.countryspinner)

        // java code  - db code
        val locales: Array<Locale> = Locale.getAvailableLocales()
        val countries = ArrayList<String>()
        for (locale in locales) {
            val country: String = locale.getDisplayCountry()
            if (country?.trim { it <= ' ' }.length > 0 && !countries.contains(country)) {
                countries.add(country)
            }
        }
        Collections.sort(countries)
        for (country in countries) {
            println(country)
        }

        //android - module 1. Array Adapter - single item,
        val countryAdapter = ArrayAdapter(this,  android.R.layout.simple_spinner_item, countries)

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yourcountrySpinnerobj.setAdapter(countryAdapter)
            }


    fun getValues(view: View) {
        val spinner2 = findViewById<Spinner>(R.id.countryspinner)
        val spinner = findViewById<Spinner>(R.id.spinner2)

        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_LONG).show()
    }


    }



