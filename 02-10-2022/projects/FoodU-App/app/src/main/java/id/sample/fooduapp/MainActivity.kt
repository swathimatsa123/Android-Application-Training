package id.sample.fooduapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.sample.fooduapp.adapter.FoodAdapter
import id.sample.fooduapp.data.Food
import id.sample.fooduapp.helper.DataHelper

class MainActivity : AppCompatActivity(), FoodAdapter.OnItemClickCallback {
    private lateinit var rvFoodList: RecyclerView
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FoodUApp) // remove splash theme, for easily showing splashscreen if there is no process in background
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // this app dosn't support dark mode
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        rvFoodList = findViewById(R.id.rv_food_list)
        foodAdapter = FoodAdapter(this, DataHelper.foodList)
        foodAdapter.setOnItemClickCallback(this)

        rvFoodList.layoutManager = GridLayoutManager(this, 1)
        rvFoodList.adapter = foodAdapter
    }

    override fun ctaItemClicked(food: Food) {
        val foodDetailIntent = Intent(this@MainActivity, FoodDetailActivity::class.java).apply {
            putExtra(FoodDetailActivity.FOOD_EXTRA, food)
        }

        startActivity(foodDetailIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_about_me -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}