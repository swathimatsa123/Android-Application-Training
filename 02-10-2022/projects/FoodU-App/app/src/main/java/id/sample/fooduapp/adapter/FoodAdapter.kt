package id.sample.fooduapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.sample.fooduapp.R
import id.sample.fooduapp.data.Food
import id.sample.fooduapp.helper.DataHelper

class FoodAdapter(private val context: Context, private var foods: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]

        holder.tvFoodTitle.text = food.name
        holder.tvFoodOwner.text = food.owner
        holder.tvFoodLocation.text = food.location
        holder.tvFoodDistance.text = "${food.distanceInKM} KM"
        holder.tvFoodCost.text = "${DataHelper.costInStringFormatted(food.cost)} IDR"
        holder.rbFoodRating.rating = food.rating

        Glide.with(context)
            .load(context.getDrawable(food.cover))
            .into(holder.ivFoodCover)

        holder.btnFoodCta.setOnClickListener {
            onItemClickCallback?.ctaItemClicked(foods[position])
        }
    }

    override fun getItemCount(): Int = foods.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFoodTitle = itemView.findViewById<TextView>(R.id.tv_item_food_title)
        val tvFoodOwner = itemView.findViewById<TextView>(R.id.tv_item_food_owner)
        val tvFoodLocation = itemView.findViewById<TextView>(R.id.tv_item_food_location)
        val tvFoodDistance = itemView.findViewById<TextView>(R.id.tv_item_food_distance)
        val tvFoodCost = itemView.findViewById<TextView>(R.id.tv_item_food_cost)
        val rbFoodRating = itemView.findViewById<RatingBar>(R.id.rb_item_food_rating)
        val ivFoodCover = itemView.findViewById<ImageView>(R.id.iv_item_food_cover)
        val btnFoodCta = itemView.findViewById<Button>(R.id.btn_item_food_cta)
    }

    interface OnItemClickCallback {
        fun ctaItemClicked(food: Food)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        onItemClickCallback = callback
    }
}