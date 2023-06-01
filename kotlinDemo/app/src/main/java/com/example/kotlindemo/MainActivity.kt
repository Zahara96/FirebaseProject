package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val counter = findViewById(R.id.counter) as LinearLayout
        val bmi = findViewById(R.id.bmi) as LinearLayout
        val calculator = findViewById(R.id.calculator) as LinearLayout


        counter.setOnClickListener {
            intent = Intent(applicationContext, ActCounter::class.java)
            startActivity(intent)
        }

        bmi.setOnClickListener {
            intent = Intent(applicationContext, ActBmi::class.java)
            startActivity(intent)
        }

        calculator.setOnClickListener {
            intent = Intent(applicationContext, ActCalculator::class.java)
            startActivity(intent)
        }
    }

}