package mobi.thru.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import androidx.gridlayout.widget.GridLayout


class ClockView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(
    context,
    attrs,
    defStyleAttr
) {

    private var clocks: Array<ImageView>
//    private lateinit var clockDrawable: ClockDrawable
    // private var grid: GridLayout


    init {
        println("****** In DigitView INIT ******")
        // inflate(context, R.layout.digit_view, this)
        // grid = findViewById(R.id.digit_view_grid)
        clocks = Array(24) {
            val clockDrawable = ClockDrawable(context)
            clockDrawable.hours = 4F
            clockDrawable.minutes = 45F
            ImageView(context).apply {
                setImageDrawable(clockDrawable)
            }
        }

        clocks.forEach {
            this.addView(it)
        }


        val row0 = spec(0, 1f)
        val row1 = spec(1, 1f)
        val row2 = spec(2, 1f)
        val row3 = spec(3, 1f)
        val row4 = spec(4, 1f)
        val row5 = spec(5, 1f)
        val col0 = spec(6, 1f)
        val col1  = spec(1 , 1F)
        val col2  = spec(2 , 1F)
        val col3  = spec(3 , 1F)
        val col4  = spec(4 , 1F)
        val col5  = spec(5 , 1F)
        val col6  = spec(6 , 1F)
        val col7  = spec(7 , 1F)

        for (i in clocks.indices) {
            when(i) {
                0 -> clocks[i].layoutParams = LayoutParams(row0, col0)
                1 -> clocks[i].layoutParams = LayoutParams(row0, col1)
                2 -> clocks[i].layoutParams = LayoutParams(row1, col0)
                3 -> clocks[i].layoutParams = LayoutParams(row1, col1)
                4 -> clocks[i].layoutParams = LayoutParams(row2, col0)
                5 -> clocks[i].layoutParams = LayoutParams(row2, col1)

                6 -> clocks[i].layoutParams = LayoutParams(row0, col2)
                7 -> clocks[i].layoutParams = LayoutParams(row0, col3)
                8 -> clocks[i].layoutParams = LayoutParams(row1, col2)
                9 -> clocks[i].layoutParams = LayoutParams(row1, col3)
                10 -> clocks[i].layoutParams = LayoutParams(row2, col2)
                11 -> clocks[i].layoutParams = LayoutParams(row2, col3)

                12 -> clocks[i].layoutParams = LayoutParams(row3, col0)
                13 -> clocks[i].layoutParams = LayoutParams(row3, col1)
                14 -> clocks[i].layoutParams = LayoutParams(row4, col0)
                15 -> clocks[i].layoutParams = LayoutParams(row4, col1)
                16 -> clocks[i].layoutParams = LayoutParams(row5, col0)
                17 -> clocks[i].layoutParams = LayoutParams(row5, col1)

                18 -> clocks[i].layoutParams = LayoutParams(row3, col2)
                19 -> clocks[i].layoutParams = LayoutParams(row3, col3)
                20 -> clocks[i].layoutParams = LayoutParams(row4, col2)
                21 -> clocks[i].layoutParams = LayoutParams(row4, col3)
                22 -> clocks[i].layoutParams = LayoutParams(row5, col2)
                23 -> clocks[i].layoutParams = LayoutParams(row5, col3)
            }
        }





//        val imageView: ImageView = findViewById(R.id.image)
//        val textView: TextView = findViewById(R.id.caption)
//
//        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BenefitView)
//        imageView.setImageDrawable(attributes.getDrawable(R.styleable.BenefitView_image))
//        textView.text = attributes.getString(R.styleable.BenefitView_text)
//        attributes.recycle()

    }

    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

//    override fun onDraw(canvas: Canvas) {
//        println("**************** Grid size: ${grid.layoutParams.width} X ${grid.layoutParams.height}}")
//
//        // grid.draw(canvas)
//
//        drawBackground(canvas)
//        drawBorder(canvas)
//        canvas.drawText("TEXT", 100F, 100F, Paint().apply {
//            color = Color.RED
//            strokeWidth = 1.5f
//            textSize = 30F
//            style = Paint.Style.FILL_AND_STROKE
//        })
//        // clockDrawable.into(clocks)
////        // drawText(canvas)
////        // drawCircle(canvas)
////        // drawCenter(canvas)
////        // drawHands(canvas)
//        postInvalidateDelayed(1000)
//        invalidate()
//        super.onDraw(canvas)
//
//    }


//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        // get view dimensions suggested by layout
//        var width = MeasureSpec.getSize(widthMeasureSpec)
//        var height = MeasureSpec.getSize(heightMeasureSpec)
//        // width should never be more than half of a screen
//        val displayWidth = context.resources.displayMetrics.widthPixels
//        width = Math.min(width, displayWidth / COLS)
//        // always make it a square (use the smaller dimension of the two)
//        if (width > height) {
//            width = height
//        } else {
//            height = width
//        }
//
////        clocks.forEach {
////            val layoutParams = it.layoutParams
////            layoutParams.width = width
////            layoutParams.height = height
////            it.layoutParams = layoutParams
////        }
//
//        // use the values
//        super.onMeasure(
//            MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
//            MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
//        )
//    }


    private fun drawBorder(canvas: Canvas) {
        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 10.5f
        paint.style = Paint.Style.STROKE
        canvas.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
    }

    private fun drawBackground(canvas: Canvas) {
        canvas.drawColor(Color.CYAN)
    }
}