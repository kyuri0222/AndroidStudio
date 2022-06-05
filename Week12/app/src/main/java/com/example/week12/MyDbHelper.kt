package com.example.week12

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class MyDbHelper(context: Context) : SQLiteOpenHelper(context,DATABASE_NAME, null, DATABASE_VERSION) {
    object MyEntry : BaseColumns {
        const val TABLE_NAME = "myTable"
        const val c1 = "name"
        const val c2 = "date"
        const val c3 = "loc"
        const val c4 = "who"
        const val c5 = "go"
    }

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${MyEntry.TABLE_NAME} (" +
                "${MyEntry.c1} TEXT PRIMARY KEY," +
                "${MyEntry.c2} TEXT," +
                "${MyEntry.c3} TEXT," +
                "${MyEntry.c4} TEXT," +
                "${MyEntry.c5} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MyEntry.TABLE_NAME}"

//    fun selectAll(): MutableList<MyElement> {
//        val readList = mutableListof<MyElement>()
//        val db = readableDatabase
//        val cursor = db.rawQuery("SELECT * FROM" + MyEntry.TABLE_NAME + ";", null)
//        Log.d("TAG", "SELECT ALL QUERY: "+"SELECT * FROM "+ MyEntry.TABLE_NAME+";")
//        Log.d("TAG", cursor.toString())
//        with(cursor) {
//            while (moveToNext()) {
//                readList.add(MyElement(
//                    cursor.getString(1),
//                    cursor.getString(2),
//                    cursor.getString(3),
//                    cursor.getString(4),
//                    cursor.getString(5))
//                )
//            }
//        }
//        cursor.close()
//        db.close()
//        return readList
//    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        var db = readableDatabase
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "myDBv2.db"
    }
}

