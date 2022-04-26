package com.example.hw6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hw6.databinding.ExamplefragmentBinding
import com.example.hw6.databinding.FragmentlayoutBinding
import android.R

class ExampleFragment : Fragment() {
    lateinit var binding: ExamplefragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ExamplefragmentBinding.inflate(layoutInflater)
        binding.image1.setOnClickListener() {
            Toast.makeText(context, "click", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        return ExamplefragmentBinding.inflate(inflater, container, false).root
    }
}

