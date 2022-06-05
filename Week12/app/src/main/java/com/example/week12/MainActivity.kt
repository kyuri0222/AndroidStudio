package com.example.week12

import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection
import android.text.Selection.selectAll
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val dbHelper = MyDbHelper(this)
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = dbHelper.writableDatabase
        val entryArr = mutableListOf(
            MyElement("뷰민라", "5/14", "올림픽공원", "데이트베이크/멜로망스", "못감"),
            MyElement("오히려좋아", "6/11", "올림픽공원", "치즈/윤딴딴", "채점해야지"),
            MyElement("파크", "5/28", "난지한강공원", "국가스텐/넬", "문제내야지")
        )
        for (entry in entryArr) {
            val values = ContentValues().apply {
                put(MyDbHelper.MyEntry.c1, entry.c1)
                put(MyDbHelper.MyEntry.c2, entry.c2)
                put(MyDbHelper.MyEntry.c3, entry.c3)
                put(MyDbHelper.MyEntry.c4, entry.c4)
                put(MyDbHelper.MyEntry.c5, entry.c5)
            }
            Log.d("TAG", values.toString())
            val newRowId = db?.insertOrThrow(MyDbHelper.MyEntry.TABLE_NAME, null, values)
            Log.d("TAG", newRowId.toString())
        }
        db.close()

//        fun selectAll(): kotlin.collections.MutableList<MyElement> {
//            val readList = mutableListof<MyElement>()
//            val db = dbHelper.readableDatabase
//            val cursor = db.rawQuery("SELECT * FROM" + MyDbHelper.MyEntry.TABLE_NAME + ";", null)
//            with(cursor) {
//                while (moveToNext()) {
//                    readList.add(MyElement(
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getString(3),
//                        cursor.getString(4),
//                        cursor.getString(5))
//                    )
//                }
//            }
//            cursor.close()
//            db.close()
//            return readList
//        }

//        val getList = Selection.selectAll()
//        val adapter = MyAdapter(getList)
//        binding.recylerView.layoutManager = LinearLayoutManager(this)
//        binding.recylerView.adapter = adapter
//
//        binding.submit.setOnClickListener {
//            db = dbHelper.writableDatabase
//            val elem = MyElement(
//                binding.name.text.toString(),
//                binding.date.text.toString(),
//                binding.loc.text.toString(),
//                binding.who.text.toString(),
//                binding.go.text.toString(),
//            )
//            val values = ContentValues().apply {
//                put(MyDbHelper.MyEntry.c1, elem.c1)
//                put(MyDbHelper.MyEntry.c2, elem.c2)
//                put(MyDbHelper.MyEntry.c3, elem.c3)
//                put(MyDbHelper.MyEntry.c4, elem.c4)
//                put(MyDbHelper.MyEntry.c5, elem.c5)
//            }
//            Log.d("TAG", values.toString())
//            try {
//                val newRowId = db?.insertOrThrow(MyDbHelper.MyEntry.TABLE_NAME, null, values)
//                Log.d("TAG", newRowId.toString())
//            } catch (e: SQLiteConstraintException) {
//                db?.update(MyDbHelper.MyEntry.TABLE_NAME, values, "${MyDbHelper.MyEntry.c1} LIKE ?", arrayOf(elem.c1))
//            }
//            val newList = selectAll()
//            adapter.setList(newList)
//            adapter.notifyDataSetChanged()
//            db.close()
//
//            }
//        adapter.setItemClickListener(object: MyAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                db = dbHelper.writableDatabase
//                db?.delete(MyDbHelper.MyEntry.TABLE_NAME,"${MyDbHelper.MyEntry.c1}=?", arrayOf(adapter.getElement(position).c1))
//                val newList = dbHelper.selectAll()
//                Toast.makeText(applicationContext, "${adapter.getElement(position).c1} is deleted", Toast.LENGTH_SHORT).show()
//                adapter.setList(newList)
//                adapter.notifyDataSetChanged()
//            }
//        })
    }
}
