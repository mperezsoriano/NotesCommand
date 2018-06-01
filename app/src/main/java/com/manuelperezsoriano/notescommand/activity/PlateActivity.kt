package com.manuelperezsoriano.notescommand.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.manuelperezsoriano.notescommand.listed.Allergens
import com.manuelperezsoriano.notescommand.R
import com.manuelperezsoriano.notescommand.model.Plate
import kotlinx.android.synthetic.main.activity_plate.*

class PlateActivity : AppCompatActivity() {

    companion object {

        val EXTRA_INDEX = "INDEX"

        fun intent(context: Context, index: Int): Intent {
            val intent = Intent(context, PlateActivity::class.java)

            intent.putExtra(EXTRA_INDEX, index)
            return intent
        }
    }

    val selecction by lazy {
        intent.getIntExtra(EXTRA_INDEX, 0)
    }

    private var plateSelect: Plate? = null
        set(value) {
            if (value != null) {
                name_text_plate.text = value.name
                price_text_plate.text = getString(R.string.price_format, value.price)
                image_plate.setImageResource(value.pictuteDish)
                description_text_plate.text = value.description
                redrawAllergens(value.allergens)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate)

        configActionBar()

        val menu = com.manuelperezsoriano.notescommand.model.Menu()
        plateSelect = menu.plates[intent.getIntExtra(EXTRA_INDEX, 0)]
    }

    private fun redrawAllergens(allergensListOfPlate: List<Allergens>) {
        for (item in allergensListOfPlate) {
            when (item.ordinal) {
                0 -> egg_allergens_image.setColorFilter(R.color.on_color)
                1 -> milk_allergens_image.setColorFilter(R.color.on_color)
                2 -> penauts_allergens_image.setColorFilter(R.color.on_color)
                3 -> mollusc_allergens_image.setColorFilter(R.color.on_color)
                4 -> gluten_allergens_image.setColorFilter(R.color.on_color)
                5 -> fish_allergens_image.setColorFilter(R.color.on_color)
                6 -> crustaceans_allergens_image.setColorFilter(R.color.on_color)
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun configActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.title_screem_4)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
