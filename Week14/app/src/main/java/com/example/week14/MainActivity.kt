package com.example.week14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.week14.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext, "Start", Toast.LENGTH_LONG).show()
        binding.btn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {

//                for (i in 1..10) {
//                    delay(1000)
//                    withContext(Dispatchers.Main) {
//                        binding.count.text = i.toString()
//                    }
//                }


                val sum = CoroutineScope(Dispatchers.Default).async {
                    var tmpSum=-1
                    for(i in 1..10) {
                        delay(100)
                        tmpSum+=i
                    }
                    tmpSum
                }.await()
                withContext(Dispatchers.Main) {
                    binding.count.text=sum.toString()
                }
            }

        }
        binding.btn2.setOnClickListener {
            Toast.makeText(applicationContext, "HiHi", Toast.LENGTH_LONG).show()
            Log.d("TAG", "Button2 Clicked")
        }
    }
}