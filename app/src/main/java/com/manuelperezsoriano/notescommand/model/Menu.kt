package com.manuelperezsoriano.notescommand.model

import com.manuelperezsoriano.notescommand.listed.Allergens
import com.manuelperezsoriano.notescommand.R


class Menu() {

    var plates = listOf(
            Plate("Espagueti oriental", 11f, R.drawable.plato1, "Espageti en salsa de soja caramelizada con toques de pimiento, pisto y nuez moscada", listOf<Allergens>(Allergens.PEANUTS), null),
            Plate("Paella de marisco", 13f, R.drawable.plato2, "Paella de de frutos del mar con gambas de Denia, hecha al fuego", listOf<Allergens>(Allergens.FISH, Allergens.MOLLUS), null),
            Plate("Cocido madrileño", 15f, R.drawable.plato3, "Cocido tradicional de garvanzos con chorico y morcilla de Teruel, alimentado con hortalizas frescas de la herta", listOf<Allergens>(), null),
            Plate("Alitas de pollo", 12f, R.drawable.plato4, "Alitas de pollo frito maceradas en miel y leche con un toque agridulce", listOf<Allergens>(Allergens.PEANUTS, Allergens.MILK), null),
            Plate("Yema de huevo con matanza", 16f, R.drawable.plato5, "Yema de huevo a baja temeratura, acompañada con productos de matanza tradicional", listOf<Allergens>(Allergens.EGGS), null),
            Plate("Atun marinado", 21f, R.drawable.plato6, "Atun del atlantico norte marinado con cacahuetes, sesamo y aceite de oliva virgen de Jaen", listOf<Allergens>(Allergens.FISH, Allergens.PEANUTS), null),
            Plate("Lenguago a la parrilla", 20f, R.drawable.plato7, "Lenguado hecho a la parrilla de fuego con mostaza", listOf<Allergens>(Allergens.FISH), null)
            )


    fun getPlate(index: Int) = plates[index]

    operator fun get(index: Int) = plates[index]

    fun toArray() = plates.toTypedArray()
}