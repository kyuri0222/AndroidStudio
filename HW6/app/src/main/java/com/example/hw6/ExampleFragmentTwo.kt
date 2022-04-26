package com.example.hw6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hw6.databinding.ExamplefragmentBinding
import com.example.hw6.databinding.ExamplefragmenttwoBinding

class ExampleFragmentTwo : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        return ExamplefragmenttwoBinding.inflate(inflater,container,false).root
    }
}