package id.sample.fooduapp.helper

import id.sample.fooduapp.R
import id.sample.fooduapp.data.Food
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class DataHelper {

    companion object {
        val foodList
            get(): ArrayList<Food> {
                val foods: ArrayList<Food> = ArrayList()

                foods.add(
                    Food(
                        "Bok Bok Korean Fried Chicken",
                        "Comes with 6 pieces of Korean fried chicken with choice of 2 flavours served with kimchi, daikon and a drink of choice",
                        "Uptown Damansara",
                        "Plaza Sentral, Jl. Jenderal Sudirman, Sudirman, Jakarta",
                        1.02, 21000, 4.5f,
                        R.drawable.k_bok_korean_fried_chicken
                    )
                )

                foods.add(
                    Food(
                        "K-Bok Burger & Chips Combo",
                        "K-Bok Burger served with seaweed fries, kimchi, daikon and a drink of choice",
                        "Uptown Damansara",
                        "Plaza Sentral, Jl. Jenderal Sudirman, Sudirman, Jakarta",
                        1.02, 22000, 4.1f,
                        R.drawable.k_bok_burger_chips_combo
                    )
                )

                foods.add(
                    Food(
                        "BK Chick'n Crisp™ Medium Set",
                        "Yummyliciously crispy chicken fillet topped with garden-fresh lettuce and creamy mayo, served on a sesame seed bun. Set comes with fries and coke",
                        "Burger King 1",
                        "Jl. KH. Royani 1, Kuningan, Jakarta",
                        1.45, 23000, 3.9f,
                        R.drawable.bk_chickn_crisp_medium
                    )
                )

                foods.add(
                    Food(
                        "BK Chick'n Crisp™ A la Carte",
                        "crispy chicken fillet topped with garden-fresh lettuce and creamy mayo, served on a sesame seed bun. Set comes with fries and coke",
                        "Burger King 1",
                        "Jl. KH. Royani 1, Kuningan, Jakarta",
                        1.45,
                        20000,
                        3.9f,
                        R.drawable.bk_chickn_crisp_a_la_carte
                    )
                )

                foods.add(
                    Food(
                        "Grilled Chicken Ala Carte",
                        "Perfectly grilled chicken patty, creamy mayo, a slice of juicy tomatoes and crunchy lettuce. It is No wonder this is one of the favourites",
                        "Burger King 6",
                        "Jl. Prof. Satrio No. 275, Setiabudi, Jakarta Selatan",
                        2.8, 240000, 4.2f,
                        R.drawable.grilled_chicken_ala_carge
                    )
                )

                foods.add(
                    Food(
                        "Triple Whopper® Jr with Cheese Medium Set",
                        "Comes with fries and coke",
                        "Burger King 1",
                        "Jl. KH. Royani 1, Kuningan, Jakarta",
                        1.45, 26000, 4.3f,
                        R.drawable.tripple_steakhouse_whopper
                    )
                )

                foods.add(
                    Food(
                        "Signature Steakhouse Whopper® ala carte",
                        "Signature Steakhouse Whopper®, a mighty burger perfectly crafted for a satisfying meal. Packed with American cheese, bacon strips, crispy onion and a mouth-watering 5-inch patty that is 100% beef and 100% flame-grilled with no preservatives or added fillers",
                        "Burger King 4",
                        "Jl. Pejaten Barat No. 69 Pejaten - Pasar Minggu Jakarta Selatan ",
                        0.7, 25000, 4.3f,
                        R.drawable.signature_steakhouse_whopper
                    )
                )

                foods.add(
                    Food(
                        "Double BBQ Beefacon™ Medium Set",
                        "Grab hold of our Double BBQ Beefacon™ with cheese slices, Beefacon™ and delicious smokey BBQ sauce to complete the sensational taste. Set comes with fries and coke",
                        "Burger King 4",
                        "Jl. Pejaten Barat No. 69 Pejaten - Pasar Minggu Jakarta Selatan ",
                        0.7, 30000, 4.8f,
                        R.drawable.double_bbq_beefacon_medium
                    )
                )

                foods.add(
                    Food(
                        "Cheeseburger Large Set",
                        "Flame-grilled beef patty topped with a simple layer of melted American cheese, crinkle cut pickles, yellow mustard, and ketchup on a toasted sesame seed bun. Set comes with fries and coke",
                        "Burger King 2",
                        "Homebase SRC, Jl. KH Royani 1 No. 14, Setiabudi, Jakarta",
                        3.02, 23000, 5.0f,
                        R.drawable.cheese_burger_larget
                    )
                )

                foods.add(
                    Food(
                        "Fried Chicken (Crispy)",
                        "Per piece. Crunchy on the outside. Juicy on the inside. Be warned, our fried chicken can be pretty addictive",
                        "Burger King 2",
                        "Homebase SRC, Jl. KH Royani 1 No. 14, Setiabudi, Jakarta",
                        3.02, 18000, 4.0f,
                        R.drawable.fried_chicken_crispy
                    )
                )

                foods.add(
                    Food(
                        "French Fries",
                        "Yummy shoe-string fires fried to a crisp golden brown",
                        "Burger King 3",
                        "Jl. Batu Jajar no. 11A, Sawah Besar, Jakarta Pusat, Indonesia ",
                        2.6,
                        19000,
                        4.7f,
                        R.drawable.french_fries
                    )
                )

                foods.add(
                    Food(
                        "Mushroom Veggie Burger",
                        "Our Mushroom Veggie Burger features our famous chunky mushroom in special sauce combination that compliments the burger so well, it's like a party in your mouth.",
                        "Burger King 3",
                        "Jl. Batu Jajar no. 11A, Sawah Besar, Jakarta Pusat, Indonesia ",
                        2.6,
                        31000,
                        5f,
                        R.drawable.mushroom_veggie_burger
                    )
                )

                foods.add(
                    Food(
                        "Salad",
                        "Something light on the tummy but super packed with great nutrients",
                        "Burger King 2",
                        "Homebase SRC, Jl. KH Royani 1 No. 14, Setiabudi, Jakarta",
                        3.02, 12000, 5f,
                        R.drawable.salad
                    )
                )

                foods.add(
                    Food(
                        "Nasi Ayam Goreng",
                        "Crispy And Savory ...",
                        "Aneka Padang",
                        "Jln. Raya Bogor Km 21 No.17 Kramat Jati Kota Jakarta Timur 13540– Indonesia ",
                        1.2,
                        13000,
                        3.2f,
                        R.drawable.nasi_ayam_goreng
                    )
                )

                foods.add(
                    Food(
                        "1 Potong Rendang Daging",
                        "Without rice",
                        "Aneka Padang",
                        "Jln. Raya Bogor Km 21 No.17 Kramat Jati Kota Jakarta Timur 13540– Indonesia ",
                        1.2,
                        16000,
                        4f,
                        R.drawable.rendang_daging
                    )
                )

                return foods
            }

        fun costInStringFormatted(cost: Long): String =
            NumberFormat.getNumberInstance(Locale.US).format(cost)
    }
}