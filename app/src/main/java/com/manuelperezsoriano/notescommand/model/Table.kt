package com.manuelperezsoriano.notescommand.model

import com.manuelperezsoriano.notescommand.listed.States

data class Table (val name: Int, var state: States, var listOrder: MutableList<Order>) {

    fun calculatePriceAcount(): Float {
        var totalPrice = 0.00f
        for (item in listOrder) {
            totalPrice += item.price
        }
        return totalPrice
    }

    fun numberOfOrder(): Int {
        return listOrder.size
    }

    fun clearListOrder() {
        listOrder.clear()
        listOrder.add(0, Order(1, "No existe pedido todavia", "", 0.0f))
    }
}