package com.example.week5buttoncal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.example.week5buttoncal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var num1: Int
        var num2: Int
        var result: Int
        binding.B1.setOnClickListener(this)
        binding.B2.setOnClickListener(this)
        binding.B3.setOnClickListener(this)
        binding.B4.setOnClickListener(this)
        binding.B5.setOnClickListener(this)
        binding.B6.setOnClickListener(this)
        binding.B7.setOnClickListener(this)
        binding.B8.setOnClickListener(this)
        binding.B9.setOnClickListener(this)

        binding.add.setOnClickListener() {
            num1 = binding.num1.text.toString().toInt()
            num2 = binding.num2.text.toString().toInt()
            result = num1 + num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.sub.setOnClickListener {
            num1 = binding.num1.text.toString().toInt()
            num2 = binding.num2.text.toString().toInt()
            result = num1 - num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.mul.setOnClickListener {
            num1 = binding.num1.text.toString().toInt()
            num2 = binding.num2.text.toString().toInt()
            result = num1 * num2
            binding.result.text = getString(R.string.results, result.toString())
        }
        binding.div.setOnClickListener {
            num1 = binding.num1.text.toString().toInt()
            num2 = binding.num2.text.toString().toInt()
            result = num1 / num2
            binding.result.text = getString(R.string.results, result.toString())
        }
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken,0)
        }
        return super.dispatchTouchEvent(ev)
    }
    override fun onClick(v:View?) {
        var input:String = (v as Button).text.toString()
        if(binding.num1.isFocused){
            input=binding.num1.text.toString() +input
            binding.num1.setText(input)
        }
        else if(binding.num2.isFocused){
            input=binding.num2.text.toString() +input
            binding.num2.setText(input)
        }
        else {
            Toast.makeText(applicationContext,"Please click num1 or num2",Toast.LENGTH_SHORT).show()
        }
    }
}

