package com.manuelperezsoriano.notescommand.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.manuelperezsoriano.notescommand.R
import com.manuelperezsoriano.notescommand.model.Room
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    companion object {
        var room = Room
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        configActionBar()

        image_table_1.setOnClickListener {
            startActivity(TableActivity.intent(this, 1))
        }

        image_table_2.setOnClickListener {
            startActivity(TableActivity.intent(this, 2))
        }

        image_table_3.setOnClickListener {
            startActivity(TableActivity.intent(this, 3))
        }

        image_table_4.setOnClickListener {
            startActivity(TableActivity.intent(this, 4))
        }

        image_table_5.setOnClickListener {
            startActivity(TableActivity.intent(this, 5))
        }

        image_table_6.setOnClickListener {
            startActivity(TableActivity.intent(this, 6))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_room, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.exit -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("RestrictedApi")
    private fun configActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.title_screem_1)
    }
}
