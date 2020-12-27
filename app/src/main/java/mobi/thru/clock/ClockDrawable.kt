package mobi.thru.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.widget.ImageView

class ClockDrawable(private val ctx: Context?) : Drawable(), Animatable {

    var index: Int = -1
        set(value) {
            field = value
            invalidateSelf()
        }

    private var _minute: Float = 7.5F
    var minute: Float
        get() = _minute
        set(value) {
            _minute = value % 60
            invalidateSelf()
        }

    private var _hours: Float = 7.5F
    var hours: Float
        get() = _hours
        set(value) {
            _hours = value % 12
            invalidateSelf()
        }

    var paint = Paint().apply {
        isAntiAlias = true
        alpha = 255
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
        strokeWidth = 5F // Stroke.THIN.toDip(ctx)
    }

//    private fun intoOldStyle(view: ImageView): ClockDrawable {
//        val _this = ClockDrawable(ctx)
//        view.setImageDrawable(_this)
//        return _this
//    }

    fun into(view: ImageView): ClockDrawable =
        ClockDrawable(ctx).apply { view.setImageDrawable(this) }


    //     ClockDrawable(ctx).apply {  }

    override fun draw(canvas: Canvas) {

//        private val frameRadius: Float get() = width / 2 - frame.strokeWidth

        // canvas.drawLine(0F, 0F, 100F, 100F, paint)
        // println("centerX, centerY, frameRadius -> $centerX, $centerY, $frameRadius")
        canvas.drawCircle(centerX, centerY, frameRadius, paint)
        // canvas.drawLine(centerX, centerY, (centerX + sin(2*PI / 60 * minute) * 100).toFloat(), (centerX - cos(2*PI / 60 * minute) * 100).toFloat(), paint)
        canvas.drawMinuteHand(centerX, centerY, minute, frameRadius, paint)
        canvas.drawHourHand(centerX, centerY, hours, frameRadius * 0.8F, paint)

        if (index != -1) {
            canvas.drawText(index.toString(), centerX + 10, centerY -10, paint)
        }


        //        canvas.drawLineWithAngle(centerX, centerY, minutesAngle, minutesRadius, pointers)
//        canvas.drawLineWithAngle(centerX, centerY, hoursAngle, hoursRadius, pointers)

    }


    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }


    override fun getOpacity() = paint.alpha

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun isRunning(): Boolean {
        TODO("Not yet implemented")
    }

//    val centerX = bounds.exactCenterX()
//    val centerY = bounds.exactCenterY()
//    val frameRadius: Float = bounds.width() / 2 - 1F

    private val frameRadius: Float get() = width / 2 - 10F

    internal val Drawable.width: Int get() = bounds.width()
    internal val Drawable.centerX: Float get() = bounds.exactCenterX()
    internal val Drawable.centerY: Float get() = bounds.exactCenterY()

}