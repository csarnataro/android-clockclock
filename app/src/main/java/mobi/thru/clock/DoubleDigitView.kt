package mobi.thru.clock

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.gridlayout.widget.GridLayout
import kotlin.math.min


class DoubleDigitView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(
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




    init {
        println("****** In DigitView INIT ******")
        inflate(context, R.layout.digit_view,this);

        clock_0_0 = findViewById<ClockImageView>(R.id.clock_0_0)
        clock_0_1 = findViewById<ClockImageView>(R.id.clock_0_1)
        clock_1_0 = findViewById<ClockImageView>(R.id.clock_1_0)
        clock_1_1 = findViewById<ClockImageView>(R.id.clock_1_1)
        clock_2_0 = findViewById<ClockImageView>(R.id.clock_2_0)
        clock_2_1 = findViewById<ClockImageView>(R.id.clock_2_1)


        // inflate(context, R.layout.digit_view, this)
        // grid = findViewById(R.id.digit_view_grid)
//        clocks = Array(6) {
//            val clockDrawable = ClockDrawable(context)
//            clockDrawable.hours = 4F
//            clockDrawable.minutes = 45F
//            ImageView(context).apply {
//                setImageDrawable(clockDrawable)
//            }
//        }
//
//        clocks.forEach {
//            this.addView(it)
//        }
//
//
//        val row0 = spec(0, 1f)
//        val row1 = spec(1, 1f)
//        val row2 = spec(2, 1f)
//        val col0 = spec(6, 1f)
//        val col1  = spec(1 , 1F)
//
//        for (i in clocks.indices) {
//            when(i) {
//                0 -> clocks[i].layoutParams = LayoutParams(row0, col0)
//                1 -> clocks[i].layoutParams = LayoutParams(row0, col1)
//                2 -> clocks[i].layoutParams = LayoutParams(row1, col0)
//                3 -> clocks[i].layoutParams = LayoutParams(row1, col1)
//                4 -> clocks[i].layoutParams = LayoutParams(row2, col0)
//                5 -> clocks[i].layoutParams = LayoutParams(row2, col1)
//            }
//        }

    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // get view dimensions suggested by layout
        var width = MeasureSpec.getSize(widthMeasureSpec) / 2
        var height = MeasureSpec.getSize(heightMeasureSpec) / 3
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
            val layoutParams = LinearLayout.LayoutParams(0,0 )
            layoutParams.width = width
            layoutParams.height = height
            layoutParams.weight = 1F
            it.layoutParams = layoutParams
        }

        // use the values
        super.onMeasure(
            MeasureSpec.makeMeasureSpec(width, MeasureSpec.UNSPECIFIED),
            MeasureSpec.makeMeasureSpec(height, MeasureSpec.UNSPECIFIED)
        )
    }

}