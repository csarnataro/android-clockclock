package mobi.thru.clock

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.BlurMaskFilter.Blur
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView


class ClockDrawable(private val ctx: Context?) : Drawable(), Animatable {

    private val framePaint = basePaint(strokeWidth = 1F)

    private val handsPaint = basePaint()

    private val shadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        alpha = 100
        strokeWidth = 3F
        style = Paint.Style.STROKE;
        maskFilter = BlurMaskFilter(12F, Blur.INNER)
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

//    var paint = Paint().apply {
//        isAntiAlias = true
//        alpha = 255
//        color = Color.BLACK
//        style = Paint.Style.STROKE
//        strokeCap = Paint.Cap.ROUND
//        strokeJoin = Paint.Join.ROUND
//        strokeWidth = 5F // Stroke.THIN.toDip(ctx)
//    }

    fun into(view: ImageView): ClockDrawable =
        ClockDrawable(ctx).apply { view.setImageDrawable(this) }

    override fun draw(canvas: Canvas) {
        drawFrame(canvas)
        canvas.drawMinuteHand(centerX, centerY, minutes, frameRadius * 0.8F, handsPaint)
        canvas.drawHourHand(centerX, centerY, hours, frameRadius * 0.6F, handsPaint)
    }

    private fun drawFrame(canvas: Canvas) {
        // Important for certain APIs
        // setLayerType(LAYER_TYPE_SOFTWARE, paint);
        canvas.drawCircle(centerX + 1, centerY + 1, frameRadius - 1, shadowPaint)
        canvas.drawCircle(centerX, centerY, frameRadius, framePaint)
    }


    override fun setAlpha(alpha: Int) {
        handsPaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        handsPaint.colorFilter = colorFilter
    }

    override fun getOpacity() = handsPaint.alpha

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

    internal fun Resources.dip(value: Int): Int = (value * displayMetrics.density).toInt()

    internal fun Context.dip(value: Int): Int = resources.dip(value)
    internal fun View.dip(value: Int): Int = resources.dip(value)

}