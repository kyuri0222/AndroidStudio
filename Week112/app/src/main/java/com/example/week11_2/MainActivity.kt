package com.example.week11_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.week11_2.databinding.ActivityMainBinding
import com.example.week11_2.databinding.ActivityViewpager2Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataSet = arrayOf(
            ImageElement("Chicken", R.drawable.item1, "나는 지금 치킨이 땡긴다"),
            ImageElement("Tteokbokki", R.drawable.item2, "나는 지금 떡볶이가 땡긴다"),
            ImageElement("Pizza", R.drawable.item3, "나는 지금 피자가 땡긴다"),
            )
        val imageAdapter = MyAdapter(dataSet)
        binding.mainTxt.text = "MENU"
        binding.viewpager2.adapter = imageAdapter

        ArrayAdapter.createFromResource(
            this,
            R.array.foods_array,
            android.R.layout.simple_spinner_item
        ). also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.foodsSpinner.adapter = arrayAdapter
        }
        binding.foodsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                binding.viewpager2.currentItem = pos
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}