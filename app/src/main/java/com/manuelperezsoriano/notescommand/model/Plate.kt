package com.manuelperezsoriano.notescommand.model

import com.manuelperezsoriano.notescommand.listed.Allergens

data class Plate (var name: String, val price: Float, val pictuteDish: Int, val description: String, val allergens: List<Allergens>, var note: String?) {
    //override fun toString() = name
}