package com.manuelperezsoriano.notescommand.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import android.widget.ListView
import com.manuelperezsoriano.notescommand.R
import com.manuelperezsoriano.notescommand.activity.RoomActivity.Companion.room
import com.manuelperezsoriano.notescommand.model.AdapterMenu
import com.manuelperezsoriano.notescommand.model.Menu
import com.manuelperezsoriano.notescommand.model.Order


class MenuActivity : AppCompatActivity() {

    private var listPlatesMenu = Menu().plates

    companion object {
        private val EXTRA_NUMBEROFTABLE = "EXTRA_NUMBEROFTABLE"

        fun intent (context: Context, numberOfTable: Int): Intent {
            val intent = Intent(context, MenuActivity::class.java)

            intent.putExtra(EXTRA_NUMBEROFTABLE, numberOfTable)
            return intent
        }
    }

    private val numberOfTable by lazy {
        intent.getIntExtra(TableActivity.EXTRA_NUMBEROFTABLE, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        configActionBar()

        val listViewMenu = findViewById<ListView>(R.id.list_menu)

        listViewMenu.adapter = AdapterMenu(this, listPlatesMenu)

        listViewMenu.setOnItemClickListener { _, _, position, _ ->
            dialogToAddPlate(position)
        }

        listViewMenu.setOnItemLongClickListener { _, _, position, _ ->
            viewInformation(position)
            true
        }
    }

    private fun viewInformation(position: Int) {
        val intent = PlateActivity.intent(this, position)
        startActivity(intent)
    }

    private fun dialogToAddPlate(position: Int) {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_menu, null)
        val noteText = dialogView.findViewById<EditText>(R.id.autoComplete_text_menu)
        dialog.setView(dialogView)
        dialog.setPositiveButton("Añadir", { _, _ ->
            addOrder(position, noteText.text.toString(), numberOfTable)
        })
        dialog.setNegativeButton("Cancelar", { _, _ -> })
        dialog.setNeutralButton("Informacion", { _, _ ->
            viewInformation(position)
        } )
        dialog.show()
    }

    private fun addOrder (position: Int, note: String, numberOfTable: Int) {
        val numberOrder = room.getNumberOrder(position)
        val plateSelection = listPlatesMenu[position].name
        val pricePlateSelecction = listPlatesMenu[position].price
        val newOrder = Order(numberOrder, plateSelection, note, pricePlateSelecction)
        room.setOrderInTable(numberOfTable, newOrder)
        Log.v("test", room.getNumberOrder(numberOfTable).toString())
    }

    @SuppressLint("RestrictedApi")
    private fun configActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.title_screem_3)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
