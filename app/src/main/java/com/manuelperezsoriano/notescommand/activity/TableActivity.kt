package com.manuelperezsoriano.notescommand.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView
import com.manuelperezsoriano.notescommand.R
import com.manuelperezsoriano.notescommand.activity.RoomActivity.Companion.room
import com.manuelperezsoriano.notescommand.model.AdapterTable

class TableActivity : AppCompatActivity() {

    private var listViewTable: ListView? = null

    companion object {

        const val EXTRA_NUMBEROFTABLE = "EXTRA_NUMBEROFTABLE"

        fun intent (context: Context, numberOfTable: Int): Intent {
            val intent = Intent(context, TableActivity::class.java)

            intent.putExtra(EXTRA_NUMBEROFTABLE, numberOfTable)
            return intent
        }
    }

    private val numberOfTable by lazy {
        intent.getIntExtra(EXTRA_NUMBEROFTABLE, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        configActionBar()
        defineListView()
    }

    override fun onRestart() {
        super.onRestart()
        defineListView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_table, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.order_button -> {
                startActivity(MenuActivity.intent(this, numberOfTable))
            }
            R.id.account_button -> {
                val totalPrice = room.getPriceAcount(numberOfTable)
                dialogToAcoount(totalPrice, numberOfTable)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun defineListView() {
        listViewTable = findViewById<ListView>(R.id.list_table)
        listViewTable?.adapter = AdapterTable(this, room.getOrderTable(numberOfTable))
        listViewTable?.deferNotifyDataSetChanged()
    }

    @SuppressLint("RestrictedApi")
    private fun configActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.title_screem_2) + " $numberOfTable"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun dialogToAcoount(price: Float, numberOfTable: Int) {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_table, null)
        val numberTable = dialogView.findViewById<TextView>(R.id.text_table_total_account)
        numberTable.text = "MESA $numberOfTable"
        val priceText = dialogView.findViewById<TextView>(R.id.price__text_total_account)
        priceText.text = "$price €"
        dialog.setView(dialogView)
        dialog.setPositiveButton("Pagar", { _, _ ->
            room.setResetTable(numberOfTable)
            finish()
        })
        dialog.setNegativeButton("Cancelar", { _, _ -> })
        dialog.show()
    }
}
