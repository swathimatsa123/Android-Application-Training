package id.sample.fooduapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import com.bumptech.glide.Glide
import id.sample.fooduapp.data.Food
import id.sample.fooduapp.helper.DataHelper

class FoodDetailActivity : AppCompatActivity() {
    private lateinit var tvFoodName: TextView
    private lateinit var tvFoodOwner: TextView
    private lateinit var tvFoodAddress: TextView
    private lateinit var tvFoodDescription: TextView
    private lateinit var tvFoodCost: TextView
    private lateinit var tvFoodDistance: TextView
    private lateinit var tvFoodTotal: TextView
    private lateinit var tvFoodRating: TextView
    private lateinit var rbFoodRating: RatingBar
    private lateinit var ivFoodCover: ImageView
    private lateinit var btnFoodAdd: Button
    private lateinit var btnFoodSubtract: Button
    private lateinit var btnAddToCart: Button

    private lateinit var food: Food
    private var total: Int = 0

    companion object {
        const val FOOD_EXTRA = "FOOD_EXTRA"
        private const val TOTAL_STATE = "TOTAL_STATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        food = intent.getParcelableExtra(FOOD_EXTRA)

        initUI()
        setUI()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TOTAL_STATE, total)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        total = savedInstanceState.getInt(TOTAL_STATE)

        updateCostUI()
        updateTotalUI()
    }

    private fun initUI() {
        tvFoodName = findViewById(R.id.tv_detail_food_name)
        tvFoodOwner = findViewById(R.id.tv_detail_food_owner)
        tvFoodAddress = findViewById(R.id.tv_detail_food_address)
        tvFoodDescription = findViewById(R.id.tv_detail_food_description)
        tvFoodCost = findViewById(R.id.tv_detail_food_cost)
        tvFoodTotal = findViewById(R.id.tv_detail_food_total)
        tvFoodDistance = findViewById(R.id.tv_detail_food_distance)
        tvFoodRating = findViewById(R.id.tv_detail_food_rating)
        rbFoodRating = findViewById(R.id.rb_detail_food_rating)
        ivFoodCover = findViewById(R.id.iv_detail_food_cover)
        btnFoodAdd = findViewById(R.id.tv_detail_food_add)
        btnFoodSubtract = findViewById(R.id.tv_detail_food_subtract)
        btnAddToCart = findViewById(R.id.btn_detail_food_cta)
    }

    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    private fun setUI() {
        tvFoodName.text = food.name
        tvFoodOwner.text = food.owner
        tvFoodAddress.text = food.location
        tvFoodDescription.text = food.description
        updateCostUI()
        tvFoodDistance.text = "${food.distanceInKM} KM"
        tvFoodRating.text = "${food.rating}"
        rbFoodRating.rating = food.rating

        Glide.with(this)
            .load(getDrawable(food.cover))
            .into(ivFoodCover)

        updateTotalUI()

        btnAddToCart.setOnClickListener {
            val message = when {
                total == 0 -> {
                    getString(R.string.detail_order_error_message)
                }
                total > 0 -> {
                    getString(R.string.detail_order_success_message)
                }
                else -> ""
            }

            Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()
        }

        btnFoodAdd.setOnClickListener {
            addTotal()
        }

        btnFoodSubtract.setOnClickListener {
            subtractTotal()
        }
    }

    private fun addTotal() {
        ++total
        updateTotalUI()
        updateCostUI()
    }

    private fun subtractTotal() {
        if (total > 0) {
            --total
        }

        updateTotalUI()
        updateCostUI()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTotalUI() {
        tvFoodTotal.text = "Total: $total"
    }

    @SuppressLint("SetTextI18n")
    private fun updateCostUI() {
        val cost: String = when {
            total == 0 -> {
                "0"
            }
            total > 0 -> {
                DataHelper.costInStringFormatted(food.cost * total)
            }
            else -> {
                DataHelper.costInStringFormatted(food.cost)
            }
        }

        tvFoodCost.text = "$cost IDR"
    }


    // Menu Options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()

            R.id.menu_item_about_me -> {
                startActivity(Intent(this@FoodDetailActivity, AboutActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}