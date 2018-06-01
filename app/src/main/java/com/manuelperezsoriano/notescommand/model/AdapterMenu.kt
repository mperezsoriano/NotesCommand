package com.manuelperezsoriano.notescommand.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.manuelperezsoriano.notescommand.R

class AdapterMenu (context: Context, lista: List<Plate>): BaseAdapter() {

    private var lista = Menu().plates

    private val mContext: Context

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        return ""
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val cell = layoutInflater.inflate(R.layout.cell_menu_listview, parent, false)

        val imageCell = cell.findViewById<ImageView>(R.id.image_cell)
        imageCell.setImageResource(lista[position].pictuteDish)

        val fisrtTextCell = cell.findViewById<TextView>(R.id.first_text_cell)
        fisrtTextCell.text = lista[position].name

        val secondTextCell = cell.findViewById<TextView>(R.id.second_text_cell)
        val calculatePrice = lista[position].price
        secondTextCell.text = "Precio de ${calculatePrice} €"

        return cell

    }
}