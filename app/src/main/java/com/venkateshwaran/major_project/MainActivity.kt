package com.venkateshwaran.major_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val populars = findViewById<Button>(R.id.Popular)
        populars.setOnClickListener {
            val intent = Intent(this@MainActivity, Popular::class.java)
            startActivity(intent)
        }
        val upcoming = findViewById<Button>(R.id.Upcoming)
        upcoming.setOnClickListener {
            val intent = Intent(this@MainActivity, Upcoming::class.java)
            startActivity(intent)
        }
        val latest = findViewById<Button>(R.id.Latest)
        latest.setOnClickListener {
            val intent = Intent(this@MainActivity, Latests::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.popularm -> {
                val intent = Intent(this@MainActivity, Popular::class.java)
                startActivity(intent)
            }
            R.id.upcomingm -> {
                val intent = Intent(this@MainActivity, Upcoming::class.java)
                startActivity(intent)
            }
            R.id.latestm -> {
                val intent = Intent(this@MainActivity, Latests::class.java)
                startActivity(intent)
            }
            R.id.exit -> {
                finish()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}