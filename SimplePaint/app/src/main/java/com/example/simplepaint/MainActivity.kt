package com.example.simplepaint

import android.content.Context
import android.graphics.*
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
        const val RECTANGLE = 3
        var curShape = LINE

        internal var historyList : MutableList<HistoryList> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SimplePainter(this))
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean{
        super.onCreateOptionsMenu(menu) //

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
                curShape = RECTANGLE
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private class SimplePainter(context: Context) : View(context){
        var startX = -1
        var startY = -1
        var stopX = -1
        var stopY = -1

        override fun onTouchEvent(event: MotionEvent?) : Boolean{
            when (event?.action){
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x.toInt()
                    startY = event.y.toInt()
                }
                MotionEvent.ACTION_MOVE -> {
                    stopX = event.x.toInt()
                    stopY = event.y.toInt()
                    this.invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    val shape = HistoryList()
                    shape.shapeType = curShape
                    shape.startX = startX
                    shape.startY = startY
                    shape.stopX = stopX
                    shape.stopY = stopY
                    historyList.add(shape)

                    this.invalidate()
                }
            }
            return true
        }

        override fun onDraw(canvas: Canvas){
            super.onDraw(canvas)
            val paint = Paint()

            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED

            for (i in historyList.indices) {
                val shape = historyList[i]
                when (shape.shapeType){

                    LINE -> canvas.drawLine(
                        shape.startX.toFloat(),
                        shape.startY.toFloat(),
                        shape.stopX.toFloat(),
                        shape.stopY.toFloat(),
                        paint
                    )

                    CIRCLE -> {
                        val radius = Math.sqrt(
                            Math.pow(
                                (shape.stopX - shape.startX).toDouble(),
                                2.0
                            ) +  Math.pow(
                                (shape.stopY - shape.startY).toDouble(),
                                2.0
                            )
                        ).toInt()
                        canvas.drawCircle(
                            shape.startX.toFloat(),
                            shape.startY.toFloat(),
                            radius.toFloat(),
                            paint
                        )
                    }

                    RECTANGLE -> canvas.drawRect(
                        shape.startX.toFloat(),
                        shape.startY.toFloat(),
                        shape.stopX.toFloat(),
                        shape.stopY.toFloat(),
                        paint
                    )
                }
            }

            when (curShape){
                LINE -> {
                    canvas?.drawLine(startX.toFloat(),startY.toFloat(),stopX.toFloat(),stopY.toFloat(),paint)
                }
                CIRCLE ->{
                    val radius = Math.sqrt(Math.pow((stopX-startX).toDouble(),2.0)+
                            Math.pow((stopY-startY).toDouble(),2.0))
                    canvas?.drawCircle(startX.toFloat(),startY.toFloat(),radius.toFloat(),paint)
                }
                RECTANGLE->{
                    val rect = Rect (startX, startX, stopX, stopY)
                    canvas.drawRect(rect, paint)
                }
            }
        }
    }
}
