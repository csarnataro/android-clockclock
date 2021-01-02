package mobi.thru.clockclock

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import androidx.gridlayout.widget.GridLayout
import kotlin.math.min


data class Time(val hour: Float, val minute: Float)


class DigitView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(
    context,
    attrs,
    defStyleAttr
) {

    var clock_0_0: ClockImageView
    var clock_0_1: ClockImageView
    var clock_1_0: ClockImageView
    var clock_1_1: ClockImageView
    var clock_2_0: ClockImageView
    var clock_2_1: ClockImageView
    val clockBaseLayoutParams = LinearLayout.LayoutParams(0, 0)

    init {
        Log.d("DigitView", "****** In DigitView INIT ******")
        inflate(context, R.layout.digit_view, this);

        clock_0_0 = findViewById(R.id.clock_0_0)
        clock_0_1 = findViewById(R.id.clock_0_1)
        clock_1_0 = findViewById(R.id.clock_1_0)
        clock_1_1 = findViewById(R.id.clock_1_1)
        clock_2_0 = findViewById(R.id.clock_2_0)
        clock_2_1 = findViewById(R.id.clock_2_1)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)


    fun set(value: Int, animate: Boolean = false) {

        val digits = getDigits(value)
        if (animate) {
            clock_0_0.animateToTime(digits[0].hour, digits[0].minute)
            clock_0_0.animateToTime(digits[0].hour, digits[0].minute)
            clock_0_1.animateToTime(digits[1].hour, digits[1].minute)
            clock_1_0.animateToTime(digits[2].hour, digits[2].minute)
            clock_1_1.animateToTime(digits[3].hour, digits[3].minute)
            clock_2_0.animateToTime(digits[4].hour, digits[4].minute)
            clock_2_1.animateToTime(digits[5].hour, digits[5].minute)
        } else {
            with(clock_0_0) { hours = digits[0].hour; minutes = digits[0].minute }
            with(clock_0_1) { hours = digits[1].hour; minutes = digits[1].minute }
            with(clock_1_0) { hours = digits[2].hour; minutes = digits[2].minute }
            with(clock_1_1) { hours = digits[3].hour; minutes = digits[3].minute }
            with(clock_2_0) { hours = digits[4].hour; minutes = digits[4].minute }
            with(clock_2_1) { hours = digits[5].hour; minutes = digits[5].minute }
        }
        invalidate()
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // get view dimensions suggested by layout
        var width = MeasureSpec.getSize(widthMeasureSpec) / 2 // 2 is the number of columns
        var height = MeasureSpec.getSize(heightMeasureSpec) / 3 // 3 is the number of rows
        // width should never be more than half of a screen
        val displayWidth = context.resources.displayMetrics.widthPixels
        width = min(width, displayWidth)
        // always make it a square (use the smaller dimension of the two)
        if (width > height) {
            width = height
        } else {
            height = width
        }

        listOf(
            clock_0_0,
            clock_0_1,
            clock_1_0,
            clock_1_1,
            clock_2_0,
            clock_2_1
        ).forEach {
            clockBaseLayoutParams.width = width
            clockBaseLayoutParams.height = height
            clockBaseLayoutParams.weight = 1F
            it.layoutParams = clockBaseLayoutParams
        }

        // use the values
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.UNSPECIFIED)
        )
    }

}