package com.example.week12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week12.databinding.ListItemBinding

class MyAdapter (private var dataSet: MutableList<MyElement>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    fun setList(newList : MutableList<MyElement>)
    {
        this.dataSet = newList
    }

    fun getElement(pos:Int): MyElement {
        return dataSet[pos]
    }
    private lateinit var itemClickListener : OnItemClickListener

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.title.text = dataSet[position].c1
        binding.date.text = dataSet[position].c2
        binding.loc.text = dataSet[position].c3
        binding.who.text = dataSet[position].c4
        binding.go.text = dataSet[position].c5
        binding.elem.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }
}
