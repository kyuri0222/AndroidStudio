package com.example.week8_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.week8_1.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)
        // lateinit var fName: String
        var fName = "${cYear}_${cMonth+1}_${cDay}.txt"
        binding.editText.setText(readDiary(fName))

        binding.datePicker.init(cYear, cMonth, cDay) { view, year, month, day ->
            fName = "${year}_${month+1}_${day}.txt"
            Log.d("TAG", fName)
            var str = readDiary(fName)
            binding.editText.setText(str)
        }
        binding.btnSmt.setOnClickListener {
            openFileOutput(fName, Context.MODE_PRIVATE).use {
                it.write(binding.editText.text.toString().toByteArray())
                Toast.makeText(applicationContext, "$fName 저장", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun readDiary(fName: String): String? {
        var diaryStr: String? = null
        try {
            openFileInput(fName).bufferedReader().forEachLine {
                if (diaryStr == null) {
                    diaryStr = it
                } else {
                    diaryStr += "\n" + it
                }
                Log.d("TAG", diaryStr!!)
                binding.btnSmt.text = "수정 하기"
            }
        } catch (e: IOException) {
            binding.editText.hint = "일기 없음"
            binding.btnSmt.text = "새로 저장"
        }
        return diaryStr
    }
}
