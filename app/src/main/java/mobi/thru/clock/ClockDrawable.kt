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

    private var _minutes: Float = 7.5F
    var minutes: Float
        get() = _minutes
        set(value) {
            _minutes = value % 60
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

    fun into(view: ImageView): ClockDrawable =
        ClockDrawable(ctx).apply { view.setImageDrawable(this) }


    override fun draw(canvas: Canvas) {
        canvas.drawCircle(centerX, centerY, frameRadius, paint)
        canvas.drawMinuteHand(centerX, centerY, minutes, frameRadius * 0.8F, paint)
        canvas.drawHourHand(centerX, centerY, hours, frameRadius * 0.6F, paint)

        if (index != -1) {
            canvas.drawText(index.toString(), centerX + 10, centerY -10, paint)
        }
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