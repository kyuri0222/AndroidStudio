package com.example.week10_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.week10_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MYTAG", "onCreate $count")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        "Count: $count".also {binding.counterTxt.text = it}
        binding.counterBtn.setOnClickListener {
            count ++
            Log.d("MYTAG", "Btn clicked $count")
            "Count : $count".also {binding.counterTxt.text = it}
        }
    }
    override fun onStart(){
        super.onStart()
        Log.d("MYTAG","onStart $count" )
    }
    override fun onResume(){
        super.onResume()
        Log.d("MYTAG","onResume $count" )
    }
    override fun onPause(){
        super.onPause()
        Log.d("MYTAG","onPause $count" )
    }
    override fun onStop(){
        super.onStop()
        Log.d("MYTAG","onStop $count" )
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("MYTAG","onDestroy $count" )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MYTAG", "onSaveInstance $count")
        outState.putInt("count",count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MYTAG", "onRestoreInstance $count")
        count = savedInstanceState.getInt("count",0)
        Log.d("MYTAG", "onRestoreInstanceLoad $count")
    }

}