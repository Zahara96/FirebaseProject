package com.example.kotlindemo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActCounter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_counter)



        val counterBtn = findViewById(R.id.button) as Button
        val resetBtn = findViewById(R.id.reset_button) as Button
        var countText = findViewById(R.id.txt) as TextView
        val actionTitle = findViewById(R.id.txtTitle) as TextView
        val actionLefitIcon = findViewById(R.id.ivActionBarLeft) as ImageView
        var timesClicked = 0


        actionTitle.text = "Counter"

        actionLefitIcon.setOnClickListener {
            finish()

        }
        counterBtn.setOnClickListener {
            timesClicked += 1
            countText.text = timesClicked.toString()

        }
        resetBtn.setOnClickListener {
            timesClicked = 0
            countText.text = ""
        }

    }

}