package com.example.simplepaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object{
        const val LINE = 1
        const val CIRCLE = 2
        const val RECT = 3

        var curShape = LINE
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SimplePainter(this))
    }
    override fun onCreateOptionsMenu(menu: Menu?) : Boolean{
        menu?.add(0,1,0,"Draw Line")
        menu?.add(0,2,0,"Draw Circle")
        menu?.add(0,3,0,"Draw Rectangle")

        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1-> {
                curShape = LINE
                return true
            }
            2-> {
                curShape = CIRCLE
                return true
            }
            3-> {
                curShape = RECT
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    class SimplePainter(context: Context) : View(context){
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f
        val paint = Paint()
        override fun onTouchEvent(event: MotionEvent?) : Boolean{
            when (event?.action){
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE,MotionEvent.ACTION_UP -> {
                    stopX = event.x
                    stopY = event.y
                    this.invalidate()
                }
            }
            return true
        }
        override fun onDraw(canvas: Canvas?){
            super.onDraw(canvas)
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED
            when (curShape){
                LINE -> {
                    canvas?.drawLine(startX,startY,stopX,stopY,paint)
                }
                CIRCLE ->{
                    val radius = Math.sqrt(Math.pow((stopX-startX).toDouble(),2.0)+
                            Math.pow((stopY-startY).toDouble(),2.0))
                    canvas?.drawCircle(startX,startY,radius.toFloat(),paint)
                }
                RECT ->{
                    val radius = Math.sqrt(Math.pow((stopX-startX).toDouble(),2.0)+
                            Math.pow((stopY-startY).toDouble(),2.0))
                    canvas?.drawCircle(startX,startY,radius.toFloat(),paint)
                }
            }
        }
    }


}