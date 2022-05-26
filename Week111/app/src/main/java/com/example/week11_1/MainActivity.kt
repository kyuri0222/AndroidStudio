package com.example.week11_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week11_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataSet = mutableListOf("When","I","was","a","young","boy","My","father","took","me","into","When","I","was","a","young","boy","My","father","took","me","into","When","I","was","a","young","boy","My","father","took","me","into")
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(dataSet)

        binding.recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        binding.addBtn.setOnClickListener{
            MyAdapter(dataSet).addItem(binding.editText.text.toString())
        }
    }
}