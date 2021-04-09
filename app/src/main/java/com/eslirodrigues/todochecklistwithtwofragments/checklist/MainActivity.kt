package com.eslirodrigues.todochecklistwithtwofragments.checklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eslirodrigues.todochecklistwithtwofragments.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.containerMainList, ListFragment()).commit()
    }
}