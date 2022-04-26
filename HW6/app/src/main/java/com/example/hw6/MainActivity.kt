package com.example.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw6.databinding.ActivityMainBinding
import com.example.hw6.databinding.ExamplefragmentBinding
import com.example.hw6.databinding.ExamplefragmenttwoBinding
import com.example.hw6.databinding.FragmentlayoutBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:FragmentlayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.button1.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,ExampleFragment())
            .commit()
        }
        binding.button2.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,ExampleFragmentTwo())
            .commit()
        }
        binding.button3.setOnClickListener { supportFragmentManager.beginTransaction()
            .replace(binding.fragView.id,ExampleFragmentThree())
            .commit()
        }
    }
}


