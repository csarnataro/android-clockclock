package mobi.thru.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class ClockView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)


    private lateinit var paint: Paint
    private lateinit var rect: Rect

    private var viewHeight = 0
    private var viewWidth = 0
    private var handTruncation = 0
    private var hourHandTruncation = 0
    private var radius = 0
    private var isInitialized = false

    private fun initClock() {
        viewHeight = height
        viewWidth = width
        val min = min(height, width)
        radius = min / 2
        handTruncation = min / 20
        hourHandTruncation = min / 7
        paint = Paint()
        rect = Rect()
        isInitialized = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (!isInitialized) {
            initClock();
        }
        drawBackground(canvas)
        // drawText(canvas)
        // drawCircle(canvas)
        // drawCenter(canvas)
        // drawHands(canvas)
        postInvalidateDelayed(1000)
        invalidate()
    }

    private fun drawHands(canvas: Canvas) {
        // val c = Calendar.getInstance()
        var hour = 0F // c.get(Calendar.HOUR_OF_DAY)
        var minute = 30F

        // hour = if (hour > 12) hour - 12 else hour
        drawHand(canvas, hourToDegrees(hour), true)
        drawHand(canvas, minuteToDegrees(minute), false)
        // drawHand(canvas, c.get(Calendar.SECOND) + (c.get(Calendar.MILLISECOND) / 1000F), false)
    }

    private fun drawHand(canvas: Canvas, loc: Float, isHour: Boolean) {
        val angle = Math.PI * loc  - Math.PI / 2 // / 30 - Math.PI / 2
        val handRadius =
            if (isHour) radius - handTruncation - hourHandTruncation else radius - handTruncation - 10
        canvas.drawLine(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (width / 2 + cos(angle) * handRadius).toFloat(),
            (height / 2 + sin(angle) * handRadius).toFloat(),
            paint
        )
    }

    private fun drawCenter(canvas: Canvas) {
        paint.style = Paint.Style.FILL
        canvas.drawCircle(width / 2F, height / 2F, 12F, paint);
    }

    fun hourToDegrees(hour: Float): Float {
        return hour * (360 / 12) - 90;
    }

    fun minuteToDegrees(minute: Float): Float {
        return minute * (360 / 60) - 90;
    }

    private fun drawCircle(canvas: Canvas) {
        paint.apply {
            reset()
            color = resources.getColor(android.R.color.white)
            strokeWidth = 5F
            style = Paint.Style.STROKE
            isAntiAlias = true
        }
        canvas.drawCircle(width / 2F, height / 2F, radius - 10F, paint);
    }

    private fun drawBackground(canvas: Canvas) {
        canvas.drawColor(Color.BLACK)
    }

}