package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            Toast.makeText(applicationContext, "Kyuri Kim", Toast.LENGTH_LONG).show()
        }

        button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            Toast.makeText(applicationContext, "60185077", Toast.LENGTH_LONG).show()
        }
    }
}



