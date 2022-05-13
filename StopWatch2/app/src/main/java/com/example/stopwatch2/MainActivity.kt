package com.example.stopwatch2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.stopwatch2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var strArray = Array<String>(5) { "" }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rdoCal.visibility = View.INVISIBLE
        binding.rdoTime.visibility = View.INVISIBLE

        binding.calenderView.visibility = View.INVISIBLE
        binding.timePicker.visibility = View.INVISIBLE

        binding.chrono.setOnClickListener{
            binding.chrono.base = SystemClock.elapsedRealtime()
            binding.chrono.start()
            binding.chrono.setTextColor(Color.RED)

            binding.rdoCal.visibility = View.VISIBLE
            binding.rdoTime.visibility = View.VISIBLE

            binding.rdoCal.setOnClickListener{
                binding.calenderView.visibility = View.VISIBLE
                binding.timePicker.visibility = View.INVISIBLE
            }
            binding.rdoTime.setOnClickListener{
                binding.calenderView.visibility = View.INVISIBLE
                binding.timePicker.visibility = View.VISIBLE
            }
        }

        binding.res.setOnLongClickListener{
            binding.chrono.stop()
            binding.chrono.setTextColor(Color.BLUE)
            binding.res.text=getString(R.string.done, strArray[0],strArray[1],strArray[2],strArray[3],strArray[4])

            binding.rdoCal.visibility = View.INVISIBLE
            binding.rdoTime.visibility = View.INVISIBLE

            binding.calenderView.visibility = View.INVISIBLE
            binding.timePicker.visibility = View.INVISIBLE
            true

        }

        binding.calenderView.setOnDateChangeListener{calendarView,year,month,day->
            strArray[0]=year.toString()
            strArray[1]=(month+1).toString()
            strArray[2]=day.toString()
        }
        binding.timePicker.setOnTimeChangedListener{timePicker,hour,min->
            strArray[3]=hour.toString()
            strArray[4]=min.toString()
        }
    }
}

