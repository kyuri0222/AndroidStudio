package com.example.week11_1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week11_1.databinding.ListItemBinding

class MyAdapter(private val dataSet: MutableList<String>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var count = 0 // 여긴 강의자료에 없던거야

    class MyViewHolder(val binding: ListItemBinding, var counter: Int) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        count++
        Log.d("TAG", "Viewholder Num: $count")
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),count)
    }

    fun addItem(item: String){
        dataSet.add(item)
        // this.notifyDataSetChanged()
        this.notifyItemInserted(dataSet.size-1)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemText.text = dataSet[position]
        binding.itemRoot.setOnClickListener{
            Log.d("TAG", "position $position counter ${holder.counter} clicked")
        }
        binding.itemRoot.setOnLongClickListener{
            Log.d("TAG", "position $position long clicked")
            dataSet.removeAt(position)
            this.notifyDataSetChanged()
            // this.notifyItemRemoved(position)
            // this.notifyItemRangeChanged(position,dataSet.size-position)
            true
        }
    }
}