//
package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var num1:Int
        var num2:Int
        var result:Int
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.add.setOnClickListener() {
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 + num2
                binding.result.text=getString(R.string.results,result.toString())
            } catch (e:NumberFormatException){
                Toast.makeText(applicationContext, "숫자를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.sub.setOnClickListener {

            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 - num2
                binding.result.text=getString(R.string.results,result.toString())
            } catch (e:NumberFormatException){
                Toast.makeText(applicationContext, "숫자를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.mul.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 * num2
                binding.result.text=getString(R.string.results,result.toString())
            } catch (e:NumberFormatException){
                Toast.makeText(applicationContext, "숫자를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }
        binding.div.setOnClickListener {
            try {
                num1 = binding.num1.text.toString().toInt()
                num2 = binding.num2.text.toString().toInt()
                result = num1 / num2
                binding.result.text=getString(R.string.results,result.toString())
            } catch (e:NumberFormatException){
                Toast.makeText(applicationContext, "숫자를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show()
            } catch (e:ArithmeticException){
                Toast.makeText(applicationContext, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
