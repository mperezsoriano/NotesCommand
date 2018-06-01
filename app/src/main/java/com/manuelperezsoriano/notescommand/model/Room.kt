package com.manuelperezsoriano.notescommand.model

import com.manuelperezsoriano.notescommand.listed.States

object Room {

    private var table: List<Table> = mutableListOf(
            Table(0, States.EMPTY, mutableListOf(Order(1, "No existe pedido tadavia", "", 0.00f))),
            Table(1, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f))),
            Table(2, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f))),
            Table(3, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f))),
            Table(4, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f))),
            Table(5, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f))),
            Table(6, States.EMPTY, mutableListOf(Order(1, "No existe pedido todavia", "", 0.00f)))
    )

    fun getOrderTable (numberTable: Int): List<Order> {
        val newNumberTable = numberTable
        table[numberTable].state = States.ATTENDED
        return table[newNumberTable].listOrder
    }

    fun setOrderInTable (numberTable: Int, newOrder: Order) {
        if (table[numberTable].listOrder[0].plate == "No existe pedido todavia") {
            table[numberTable].listOrder.clear()
        }
        table[numberTable].listOrder.add(newOrder)
    }

    fun setResetTable (numberTable: Int) {
        table[numberTable].clearListOrder()
        table[numberTable].state = States.EMPTY
    }


    fun getPriceAcount (numberTable: Int): Float {
        return table[numberTable].calculatePriceAcount()
    }

    fun getNumberOrder (numberTable: Int): Int {
        return table[numberTable].numberOfOrder()
    }

    fun getStatusTable (numberTable: Int): States {
        return table[numberTable].state
    }
}