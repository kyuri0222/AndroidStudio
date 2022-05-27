package com.example.week11_2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week11_2.databinding.ListItemBinding

class MyAdapter(private val dataSet: Array<ImageElement>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun getItemCount() = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemText.text = dataSet[position].name
        binding.itemTextBottom.text = dataSet[position].something
        binding.imageContent.setImageResource(dataSet[position].src)
        binding.itemRoot.setOnClickListener{
            Log.d("TAG", "position $position clicked")
        }
    }
}















