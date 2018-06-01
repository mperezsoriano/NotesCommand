package com.manuelperezsoriano.notescommand.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.manuelperezsoriano.notescommand.R

class AdapterTable(context: Context, listaOfTable: List<Order>): BaseAdapter(){

    private var lista = listaOfTable

    private val mContext: Context = context

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
        val cell = layoutInflater.inflate(R.layout.cell_table_listview, parent, false)

        val nameTextCell = cell.findViewById<TextView>(R.id.name_text_cell)
        nameTextCell.text = lista[position].plate

        val noteTextCell = cell.findViewById<TextView>(R.id.note_text_cell)
        noteTextCell.text = lista[position].note

        return cell
    }
}