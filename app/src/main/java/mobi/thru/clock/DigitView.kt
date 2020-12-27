package mobi.thru.clock

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.gridlayout.widget.GridLayout


class DigitView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : GridLayout(
    context,
    attrs,
    defStyleAttr
) {

    private var clocks: Array<ImageView>
//    private lateinit var clockDrawable: ClockDrawable
    private var grid: GridLayout


    init {
        println("****** In DigitView INIT ******")
        inflate(context, R.layout.digit_view, this)
        grid = findViewById(R.id.digit_view_grid)

        clocks = Array(6) {
            val clockDrawable = ClockDrawable(context)
            clockDrawable.hours = 4F
            clockDrawable.minute = 45F
            ImageView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    this.width = 125
                    this.height = 125
                }
                setImageDrawable(clockDrawable)
            }
        }

        clocks.forEach {
            grid.addView(it)
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