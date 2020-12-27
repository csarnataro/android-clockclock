package mobi.thru.clock

import android.graphics.Canvas
import android.graphics.Paint
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

internal fun Canvas.drawMinuteHand(centerX: Float, centerY: Float, minute: Float, length: Float, paint: Paint) {
    val minuteAngle = 2 * PI / 60 * minute
    drawLine(
        centerX,
        centerY,
        (centerX + sin(minuteAngle) * length).toFloat(),
        (centerX - cos(minuteAngle) * length).toFloat(),
        paint
    )
}

internal fun Canvas.drawHourHand(centerX: Float, centerY: Float, hour: Float, length: Float, paint: Paint) {
    val hourAngle = 2 * PI / 12 * hour
    drawLine(
        centerX,
        centerY,
        (centerX + sin(hourAngle) * length).toFloat(),
        (centerX - cos(hourAngle) * length).toFloat(),
        paint
    )
}
