package com.eslirodrigues.todochecklistwithtwofragments.checklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.eslirodrigues.todochecklistwithtwofragments.R
import com.eslirodrigues.todochecklistwithtwofragments.twofragments.TwoFragmentsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.containerMainList, ListFragment()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuTwoFragmentsCount -> startActivity(Intent(this, TwoFragmentsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}