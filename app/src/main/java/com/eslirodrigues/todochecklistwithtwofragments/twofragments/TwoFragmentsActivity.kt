package com.eslirodrigues.todochecklistwithtwofragments.twofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eslirodrigues.todochecklistwithtwofragments.R

class TwoFragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_fragments)

        supportFragmentManager.beginTransaction().add(R.id.containerButton, ButtonFragment())
            .add(R.id.containerCount, CountFragment()).commit()
    }
}